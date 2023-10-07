# 11. Container With Most Water

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

> Input: height = `[1,8,6,2,5,4,8,3,7]`
>
> Output: `49`
>
> Explanation: The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`. In this case, the max area of water (blue section) the container can contain is `49`.

::::{tab-set}

:::{tab-item} Two Pointer

```{code-block} java
public int maxArea(int[] height) {
  int maxArea = 0;
  int left = 0, right = height.length - 1;

  while (left < right) {
    int minHeight = Math.min(height[left], height[right]);
    int currentArea = (right - left) * minHeight;
    maxArea = Math.max(maxArea, currentArea);

    if (height[left] < height[right]) {
      left++;
    } else {
      right--;
    }
  }
  return maxArea;
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |

:::

::::
