import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadLocalUsage {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(4);

    IntStream
      .range(1, 10)
      .forEach(i ->
        executor.execute(() -> {
          System.out.println(
            Thread.currentThread().getName() + " Id: " + ThreadId.get()
          );
        })
      );

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);
  }
}

class ThreadId {

  private static final AtomicInteger id = new AtomicInteger(0);
  private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() ->
    id.incrementAndGet()
  );

  public static int get() {
    return threadId.get();
  }
}
