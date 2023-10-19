# 733. Flood Fill

```{code-block} java
:linenos:
:dedent: 2

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int currentColor = image[sr][sc];
    dfs(image, sr, sc, currentColor, color);
    return image;
  }

  private void dfs(
    int[][] image,
    int m,
    int n,
    int currentColor,
    int newColor
  ) {
    if (m < 0 || m >= image.length || n < 0 || n >= image[0].length) {
      return;
    }

    if (image[m][n] == newColor || image[m][n] != currentColor) {
      return;
    }

    image[m][n] = newColor;

    dfs(image, m, n + 1, currentColor, newColor);
    dfs(image, m + 1, n, currentColor, newColor);
    dfs(image, m, n - 1, currentColor, newColor);
    dfs(image, m - 1, n, currentColor, newColor);
  }
```
