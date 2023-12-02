import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueImplementationDriver {

  public static void main(String[] args) {
    BlockingQueueUsingSynchronized<Integer> q = new BlockingQueueUsingSynchronized<>(
      5
    );

    // producer
    new Thread(() -> {
      try {
        for (int i = 0; i < 20; ++i) {
          q.put(i);
          System.out.println("Produced: " + i);
        }
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    })
      .start();

    // consumer 1
    new Thread(() -> {
      try {
        for (int i = 0; i < 10; ++i) {
          System.out.println("C1 Consumed: " + q.take());
        }
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    })
      .start();

    // consumer 2
    new Thread(() -> {
      try {
        for (int i = 0; i < 10; ++i) {
          System.out.println("C2 Consumed: " + q.take());
        }
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    })
      .start();
  }
}

class BlockingQueueUsingSynchronized<T> {

  private Queue<T> queue;
  private int capacity;

  public BlockingQueueUsingSynchronized(int capacity) {
    this.capacity = capacity;
    this.queue = new LinkedList<>();
  }

  public synchronized void put(T element) throws InterruptedException {
    while (queue.size() == capacity) {
      wait(); // wait if Q is full
    }

    queue.add(element);
    notifyAll();
  }

  public synchronized T take() throws InterruptedException {
    while (queue.isEmpty()) {
      wait(); // wait if Q is empty
    }

    T item = queue.remove();
    notifyAll();
    return item;
  }
}
