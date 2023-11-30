import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class BlockingQueueUsage {

  public static void main(String[] args) {
    BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);

    new Thread(new Producer(q)).start();
    new Thread(new Consumer(q)).start();
    new Thread(new Consumer(q)).start();
  }
}

class Producer implements Runnable {

  private final BlockingQueue<Integer> q;

  Producer(BlockingQueue<Integer> q) {
    this.q = q;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int value = ThreadLocalRandom.current().nextInt();
        System.out.println("Produced value: " + value);
        Thread.sleep(1000);
        q.put(value);
      }
    } catch (InterruptedException ignore) {}
  }
}

class Consumer implements Runnable {

  private final BlockingQueue<Integer> q;

  Consumer(BlockingQueue<Integer> q) {
    this.q = q;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int value = q.take();
        System.out.println(
          Thread.currentThread().getName() + " Consumed value: " + value
        );
      }
    } catch (InterruptedException ignore) {}
  }
}
