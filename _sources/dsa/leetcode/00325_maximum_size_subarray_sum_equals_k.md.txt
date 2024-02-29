# [325. Maximum Size Subarray Sum Equals k](https://www.lintcode.com/problem/911/)

Given an array `nums` and a target value `k`, find the maximum length of a subarray that sums to `k`. If there isn't one, return 0 instead.

**Example 1**

```
Input:  nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation: subarray [1, -1, 5, -2] sums to 3 and is the longest.
```

**Example 2**

```
Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation: subarray [-1, 2] sums to 1 and is the longest.
```

## Approach 1: Using two loops

```{code-block} java
:linenos:
:emphasize-lines: 7

public class Solution {

  public int maxSubArrayLen(int[] nums, int k) {
    int maxLen = 0;
    for (int i = 0; i < nums.length; ++i) {
      int currentSum = 0;
      for (int j = i; j < nums.length; ++j) {
        currentSum += nums[j];

        if (currentSum == k) {
          maxLen = Math.max(maxLen, j - i + 1);
        }
      }
    }
    return maxLen;
  }
}
```

## Approach 2: Using prefix sum in HashMap

```{code-block} java
:linenos:
:emphasize-lines: 1

public class Solution {

  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int prefixSum = 0;
    int maxLen = 0;

    for (int i = 0; i < nums.length; ++i) {
      prefixSum += nums[i];
      if (map.containsKey(prefixSum - k)) {
        maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
      }
      map.putIfAbsent(prefixSum, i);
    }

    return maxLen;
  }
}
```
