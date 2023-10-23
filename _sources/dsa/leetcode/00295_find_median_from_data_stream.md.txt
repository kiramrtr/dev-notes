# [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

```{code-block} java
:linenos:

class MedianFinder {
  PriorityQueue<Integer> lowers;
  PriorityQueue<Integer> highers;

  public MedianFinder() {
    lowers = new PriorityQueue<>(Collections.reverseOrder());
    highers = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (lowers.isEmpty() || num < lowers.peek()) {
      lowers.add(num);
    } else {
      highers.add(num);
    }

    // re-balance
    if (lowers.size() - highers.size() > 1) {
      highers.add(lowers.remove());
    }

    if (highers.size() - lowers.size() > 1) {
      lowers.add(highers.remove());
    }
  }

  public double findMedian() {
    if (lowers.size() > highers.size()) {
      return lowers.peek();
    } else if (highers.size() > lowers.size()) {
      return highers.peek();
    } else {
      return ((double) highers.peek() + lowers.peek()) / 2;
    }
  }
}
```
