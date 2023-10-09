# [57. Insert Interval](https://leetcode.com/problems/insert-interval/)

Given a sorted array of non-overlapping intervals (`intervals`) and a new interval (`newInterval`), insert `newInterval` into `intervals` while maintaining sorted order and merging overlapping intervals if necessary. Return the updated `intervals`.

**Example 1:**

```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

**Example 2:**

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: The new interval [4,8] overlaps with [3,5],[6,7],[8,10]
```

## Approach

When comparing two intervals _P_ and _Q_ it can be:

1. _P_ can come before _Q_.
2. _Q_ can come before _P_.
3. _P_ and _Q_ can be overlapped then, merge by taking _MIN_ of `start` and _MAX_ of `end`.

Loop over intervals and compare new and current and add or merge accordingly.

## Code

```{code-block} java
:linenos:

public int[][] insert(int[][] intervals, int[] newInterval) {
  List<int[]> list = new ArrayList<>();
  boolean inserted = false;

  for (int[] currentInterval : intervals) {
    if (inserted || currentInterval[1] < newInterval[0]) {
      // when current interval is before new interval
      list.add(currentInterval);
    } else if (newInterval[1] < currentInterval[0]) {
      // when new interval is before current interval
      list.add(newInterval);
      inserted = true;

      list.add(currentInterval);
    } else {
      // when overlapping exists
      newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
      newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
    }
  }

  if (!inserted) {
    list.add(newInterval);
  }

  return list.toArray(new int[list.size()][]);
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(n)$ |
