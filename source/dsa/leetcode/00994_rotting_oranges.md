# 994. Rotting Oranges

```{code-block} java
:linenos:

public int orangesRotting(int[][] grid) {
  Queue<int[]> q = new LinkedList<>();
  int freshOrangesCount = 0;
  int minutes = 0;

  int m = grid.length;
  int n = grid[0].length;

  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < n; ++j) {
      if (grid[i][j] == 1) {
        freshOrangesCount++;
      } else if (grid[i][j] == 2) {
        // add rotten orange cells to Q for BFS
        q.add(new int[] { i, j });
      }
    }
  }

  int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  while (!q.isEmpty() && freshOrangesCount > 0) {
    int qLen = q.size();

    for (int i = 0; i < qLen; ++i) {
      int[] ro = q.remove();
      for (int[] direction : directions) {
        int x = ro[0] + direction[0];
        int y = ro[1] + direction[1];
        if (x < 0 || x >= m || y < 0 || y >= n) {
          continue;
        }

        if (grid[x][y] == 1) {
          freshOrangesCount--;
          grid[x][y] = 2;
          q.add(new int[] { x, y });
        }
      }
    }
    minutes++;
  }

  if (freshOrangesCount > 0) {
    return -1;
  }

  return minutes;
}
```
