# Concurrency

## Todo:

- [ ] _lost update_
- [ ] _happens before_

### Race Condition

> https://web.mit.edu/6.031/www/sp21/classes/20-concurrency/#race_condition

A **_race condition_** means that the correctness of the program depends on the relative timing of events in concurrent computations _A_ and _B_. When this happens we say "A is in race with B."

- _check-then-act_: a potentially stale observation is used to decide what to do next.
- _read-modify-write_: new state is derived from previous state (may be stale). e.g., `count++`.

## Synchronizers

### [`CountDownLatch`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CountDownLatch.html)

A synchronization aid that allows one or more threads (by calling `await()`) to wait until a set of operations being performed in other threads completes.

- Initialized with a given _count_.
- The `await` method blocks until the current count is reached to zero due to invocations of the `countDown()`.
- If _count_ is already zero invocation to `await` returns immediately.
- The _count_ cannot be reset.
- Threads calling `countDown` need not wait for the count.

**Use cases:**

- A CountDownLatch with a count of one serves as a simple on/off latch, or gate: all thread invoking `await` wait at the gate until it is opened by a thread invoking `countDown()`.
- A CountDownLatch initialized to _N_ can be used to make one thread wait until _N_ threads have completed some action, or some action has been completed _N_ times.

```java
class Driver {
    private static final int N = 10;

    public static void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; i++>) {
            new Thread(new Workder(startSignal, doneSignal)).start();
        }

        doSomeWorkBeforeWorker();
        startSignal.countDown();
        doSomeWork();
        doneSignal.await();
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            System.out.println("I got interrupted :-()");
            return;
        }
    }

    void doWork() {
        System.out.println("Doing work...");
    }
}
```

## Liveness

Ability to make progress.

- Deadlock
- Livelock
- Starvation

### Deadlock

### Livelock

- A thread often acts in response to the action of another thread. If the other thread's action is also a response to the action of another thread, then _livelock_ may result.
- As with deadlock, livelocked threads are unable to make further progress. However, the threads are not blocked they are simply too busy responding to each other to resume work.

> https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html
