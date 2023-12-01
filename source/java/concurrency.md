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

### Semaphore

A counting _semaphore_ maintains a set of permits that can be acquired and released. If a permit is unavailable, the acquire operation will block the thread."

## Liveness

Ability to make progress.

- Deadlock
- Livelock
- Starvation

### Deadlock

_Deadlock_ is a situation where two or more threads are blocked forever, waiting for each other.

:::{dropdown} Broken

```{code-block} java
:linenos:
:emphasize-lines: 19,28

public class Deadlock {
  public static void main(String[] args) {
    Account a = new Account("A", 1000);
    Account b = new Account("B", 1000);

    Thread t1 = new Thread(() -> transfer(a, b, 200));
    Thread t2 = new Thread(() -> transfer(b, a, 100));

    t1.start();
    t2.start();
  }

  public static void transfer(Account from, Account to, int amount) {
    System.out.println(
      Thread.currentThread().getName() +
      ": trying to acquired lock of " +
      from.getId()
    );
    synchronized (from) {
      System.out.println(
        Thread.currentThread().getName() + ": lock acquired on " + from.getId()
      );
      System.out.println(
        Thread.currentThread().getName() +
        ": trying to acquired lock of " +
        to.getId()
      );
      synchronized (to) {
        System.out.println(
          Thread.currentThread().getName() + ": lock acquired on " + to.getId()
        );
        from.debit(amount);
        to.credit(amount);
      }
    }
    System.out.println("Transfer completed");
  }
}

class Account {
  private final String id;
  private int balance;

  public Account(String id, int balance) {
    this.id = id;
    this.balance = balance;
  }

  public void debit(int amount) {
    balance -= amount;
  }

  public void credit(int amount) {
    balance += amount;
  }

  public String getId() {
    return id;
  }

  public int getBalance() {
    return balance;
  }
}
```

:::

:::{dropdown} Fixed

```{code-block} java
:linenos:
:emphasize-lines: 15-16,18-21,28,37

public class Deadlock {

  public static void main(String[] args) {
    Account a = new Account("A", 1000);
    Account b = new Account("B", 1000);

    Thread t1 = new Thread(() -> transfer(a, b, 200));
    Thread t2 = new Thread(() -> transfer(b, a, 100));

    t1.start();
    t2.start();
  }

  public static void transfer(Account from, Account to, int amount) {
    Account first = from;
    Account second = to;

    if (from.getId().compareTo(to.getId()) >= 0) {
      first = to;
      second = from;
    }

    System.out.println(
      Thread.currentThread().getName() +
      ": trying to acquired lock of " +
      first.getId()
    );
    synchronized (first) {
      System.out.println(
        Thread.currentThread().getName() + ": lock acquired on " + first.getId()
      );
      System.out.println(
        Thread.currentThread().getName() +
        ": trying to acquired lock of " +
        to.getId()
      );
      synchronized (second) {
        System.out.println(
          Thread.currentThread().getName() +
          ": lock acquired on " +
          second.getId()
        );
        from.debit(amount);
        to.credit(amount);
      }
    }
    System.out.println("Transfer completed");
  }
}

class Account {
  private final String id;
  private int balance;

  public Account(String id, int balance) {
    this.id = id;
    this.balance = balance;
  }

  public void debit(int amount) {
    balance -= amount;
  }

  public void credit(int amount) {
    balance += amount;
  }

  public String getId() {
    return id;
  }

  public int getBalance() {
    return balance;
  }
}
```

:::

### Livelock

- A thread often acts in response to the action of another thread. If the other thread's action is also a response to the action of another thread, then _livelock_ may result.
- As with deadlock, livelocked threads are unable to make further progress. However, the threads are not blocked they are simply too busy responding to each other to resume work.

> https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html

## BlockingQueue

> A _Queue_ that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.

|             | Throws exception | Special value | Blocks           | Times out              |
| ----------- | ---------------- | ------------- | ---------------- | ---------------------- |
| **Insert**  | `add(e)`         | `offer(e)`    | `put(e)`         | `offer(e, time, unit)` |
| **Remove**  | `remove()`       | `poll()`      | `take()`         | `poll(time, unit)`     |
| **Examine** | `element()`      | `peek()`      | _not applicable_ | _not applicable_       |

- Does not accept `null` elements

### Producer Consumer

```{literalinclude} concurrency/BlockingQueueUsage.java
:language: java
:linenos:
:lines: 5-

```

## ThreadLocal

- This class provides thread-local variables, which are distinct from regular variables in that each thread accessing one via its `get` or `set` method has a separate, independently initialized copy.
- `ThreadLocal` instances are commonly `private static` fields in classes that aim to associate state with a thread, such as a user ID or transaction ID.
- Each thread maintains an implicit reference to its thread-local variable copy as long as the thread is alive and the `ThreadLocal` instance is accessible. Once the thread ceases, all its thread-local variable copies become eligible for garbage collection, unless there are other references to these copies.

Use cases:

- Thread confinement
- Per thread object for performance
- Per thread context

```{literalinclude} concurrency/ThreadLocalUsage.java
:language: java
:linenos:
:lines: 6-
:emphasize-lines:

```

Tips:

- Cleanup once not required anymore
- Delegate to frameworks e.g., Spring context holders
