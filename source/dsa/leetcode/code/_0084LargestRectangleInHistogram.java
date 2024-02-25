package source.dsa.leetcode.code;

import java.util.Deque;
import java.util.Stack;

public class _0084LargestRectangleInHistogram {

  class Solution {

    public int largestRectangleArea(int[] heights) {
      int maxArea = 0;
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < heights.length; ++i) {
        int current = heights[i];
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
          int height = heights[stack.pop()];
          int width = i;
          maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
      }
      return maxArea;
    }
  }

  public static void main(String[] args) {
    _0084LargestRectangleInHistogram w = new _0084LargestRectangleInHistogram();
    Solution s = w.new Solution();
    System.out.println(s.largestRectangleArea(new int[] { 1, 2, 1 }));
  }
}
