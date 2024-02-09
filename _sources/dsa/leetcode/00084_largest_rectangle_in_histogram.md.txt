# 84. Largest Rectangle in Histogram

## Approach 1: Using two for loops (Time Limit Exceeded)

```{code-block} java
:linenos:

class Solution {

  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;

    for (int i = 0; i < heights.length; ++i) {
      int currentMin = heights[i];
      for (int j = i; j < heights.length; ++j) {
        currentMin = Math.min(currentMin, heights[j]);
        maxArea = Math.max(maxArea, currentMin * (j - i + 1));
      }
    }

    return maxArea;
  }
}
```

## Approach 2: Using two for loops with search pruning (Time Limit Exceeded)

```{code-block} java
:linenos:
:emphasize-lines: 6-8

class Solution {

  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;

    for (int i = 0; i < heights.length; ++i) {
      if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
        continue;
      }
      int currentMin = heights[i];
      for (int j = i; j >= 0; --j) {
        currentMin = Math.min(currentMin, heights[j]);
        maxArea = Math.max(maxArea, currentMin * (i - j + 1));
      }
    }

    return maxArea;
  }
}
```

## Approach 3: Using Monotonic Stack (increasing)

```{code-block} java
:linenos:

class Solution {

  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i <= heights.length; ++i) {
      while (
        !stk.isEmpty() &&
        (i == heights.length || heights[stk.peek()] > heights[i])
      ) {
        int height = heights[stk.pop()];
        int width = stk.isEmpty() ? i : (i - stk.peek() - 1);
        maxArea = Math.max(maxArea, height * width);
      }

      stk.push(i);
    }

    return maxArea;
  }
}
```
