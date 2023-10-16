# 973. K Closest Points to Origin

## Code

```{code-block} java
:linenos:

public int[][] kClosest(int[][] points, int k) {
  int[][] result = new int[k][2];

  Comparator<int[]> distanceComparator = (int[] a, int[] b) -> {
    int aDist = (a[0] * a[0]) + (a[1] * a[1]);
    int bDist = (b[0] * b[0]) + (b[1] * b[1]);
    return Integer.compare(aDist, bDist);
  };

  PriorityQueue<int[]> pq = new PriorityQueue<>(k, distanceComparator);

  for (int[] point : points) {
    pq.add(point);
  }

  for (int i = 0; i < k; i++) {
    result[i] = pq.remove();
  }

  return result;
}
```

|   Time Complexity    | Space Complexity |
| :------------------: | :--------------: |
| $\mathcal{O}(nlogk)$ | $\mathcal{O}(n)$ |
