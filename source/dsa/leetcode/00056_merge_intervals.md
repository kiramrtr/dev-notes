# 56. Merge Intervals

## Code

```{code-block} java
public int[][] merge(int[][] intervals) {
  Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
  List<int[]> res = new ArrayList<>();
  res.add(intervals[0]);

  for (int i = 1; i < intervals.length; i++) {
    int[] current = intervals[i];
    int[] prev = res.get(res.size() - 1);

    // previous interval end is >= to current start
    // then they are overlapping
    if (prev[1] >= current[0]) {
      prev[1] = Math.max(prev[1], current[1]);
    } else {
      res.add(current);
    }
  }

  return res.toArray(new int[res.size()][]);
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(n)$ |
