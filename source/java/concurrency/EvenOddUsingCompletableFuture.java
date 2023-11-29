import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddUsingCompletableFuture {

  public static void main(String[] args) {
    ExecutorService firstExecutorService = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r);
        t.setName("first");
        return t;
      }
    );

    ExecutorService secondExecutorService = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r);
        t.setName("second");
        return t;
      }
    );

    IntStream
      .range(1, 101)
      .forEach(num -> {
        CompletableFuture<Integer> thenApplyAsync = CompletableFuture
          .completedFuture(num)
          .thenApplyAsync(
            x -> {
              if (x % 2 == 1) {
                System.out.println(x + " " + Thread.currentThread().getName());
              }
              return num;
            },
            firstExecutorService
          );
        thenApplyAsync.join();

        CompletableFuture<Integer> thenApplyAsync2 = CompletableFuture
          .completedFuture(num)
          .thenApplyAsync(
            x -> {
              if (x % 2 == 0) {
                System.out.println(x + " " + Thread.currentThread().getName());
              }
              return num;
            },
            secondExecutorService
          );
        thenApplyAsync2.join();
      });

    firstExecutorService.shutdown();
    secondExecutorService.shutdown();
  }
}
