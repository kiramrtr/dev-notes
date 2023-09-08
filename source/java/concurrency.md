# Concurrency

## Synchronizers

### [`CountDownLatch`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CountDownLatch.html)

- A synchronization aid that allows that allows one or more threads (by calling `await()`) to wait until a set of operations being performed in othe threads completes.
- Initialized with a given _count_.
- The `await()` method blocks until the current count reached zero due to invocations of the `countDown()`.
- If _count_ is already zero invocation to `await` returns immediately.
- The count cannot be reset.
- Threads calling `ccountDown` need not wait for the count

**Use cases:**

- A CountDownLatch with a count of one serves as a simple on/off latch, or gate: all thread invoking `await` wait at the gate until it is opened by a thread invoking `countDown()`.
- A CountDownLatch intialized to _N_ can be used to make one thread wait until _N_ threads have completed some action, or some action has been completed _N_ times.

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
    private final CountDownLatch startSingal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSingal, CountDownLatch doneSignal) {
        this.startSingal = startSingal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSingal.countDown();
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
