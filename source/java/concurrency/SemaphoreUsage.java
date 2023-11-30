import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SemaphoreUsage {

  private static AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore = new Semaphore(3);

    ExecutorService executor = Executors.newFixedThreadPool(10);

    IntStream
      .rangeClosed(1, 20)
      .forEach(i -> executor.submit(new Task(semaphore, counter)));

    while (counter.get() < 20) {
      // wait till 20 tasks get completed
    }

    System.out.println("Counter: " + counter.get());
    System.out.println("Shuting down executors...");
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);
  }
}

class Task implements Runnable {

  private final Semaphore semaphore;
  private final AtomicInteger counter;

  public Task(Semaphore semaphore, AtomicInteger counter) {
    this.semaphore = semaphore;
    this.counter = counter;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " Aquiring permit");

      semaphore.acquire();

      System.out.println(Thread.currentThread().getName() + " Permit acquired");

      System.out.println(Thread.currentThread().getName() + " Doing work...");

      Thread.sleep(110);

      System.out.println(
        Thread.currentThread().getName() + " Releasing permit"
      );

      semaphore.release();
      counter.incrementAndGet();

      System.out.println(Thread.currentThread().getName() + " Permit released");
    } catch (InterruptedException ignore) {
      ignore.printStackTrace();
    }
  }
}
