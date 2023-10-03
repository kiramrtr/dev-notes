# LeetCode

## [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

::::{tab-set}

:::{tab-item} Brute-force

```{code-block} java
---
emphasize-lines: 7-10
linenos:
---
public int subarraySum(int[] nums, int k) {
  int matchCount = 0;

  for (int i = 0; i < nums.length; i++) {
    for (int j = i; j < nums.length; j++) {
      int sum = 0;
      // sum elements from i to j
      for (int x = i; x <= j; x++) {
        sum = sum + nums[x];
      }

      if (sum == k) {
        matchCount++;
      }
    }
  }

  return matchCount;
}
```

:::

::::

## [2716. Minimize String Length](https://leetcode.com/problems/minimize-string-length/)

**Approach**

As given string contains only lowercase english letters, we can have an array of size 26 and keeping track of the count and counting characters not seen already.

```java
class Solution {

  public int minimizedStringLength(String s) {
    int[] charCount = new int[26];
    int length = 0;

    for (int i = 0; i < s.length(); i++) {
      if (charCount[s.charAt(i) - 'a'] == 0) {
        charCount[s.charAt(i) - 'a']++;
        length++;
      }
    }

    return length;
  }
}
```
