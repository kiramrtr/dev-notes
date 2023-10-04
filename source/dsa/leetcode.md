# LeetCode

## [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

:::{table}
:class: ps-ex1

| Index $i$               |   0 |   1 |   2 |   3 |   4 |   5 |   6 |
| ----------------------- | --: | --: | --: | --: | --: | --: | --: |
| $\texttt{arr}[i]$       |   1 |   6 |   4 |   2 |   5 |   3 |   - |
| $\texttt{prefixSum}[i]$ |   0 |   1 |   7 |  11 |  13 |  18 |  21 |

:::

Prefix sum can be calculated in $\mathcal{O}(n)$ by the below formula:

$$
\texttt{prefixSum}[i] = \texttt{prefixSum}[i - 1] + \texttt{arr}[i - 1]
$$

Now, the sum of the elements of $\texttt{arr}$ from $\textit{L}$ to $\textit{R}$ can be computed using:

$$
\sum_{i=L}^{R} \texttt{arr}[i] = \sum_{i=0}^{R} \texttt{arr}[i] - \sum_{i=0}^{L-1} \texttt{arr}[i]
$$

Using the prefix sum array, the same can be

$$
\sum_{i=L}^{R} \texttt{arr}[i] = \texttt{prefixSum}[R+1] - \texttt{prefixSum}[L]
$$

Example should make it more clearer:

$$
\sum_{1=1}^{4} \texttt{arr}[i] = \sum_{i=0}^{4} \texttt{arr}[i]  - \sum_{i=0}^{0} \texttt{arr}[i] \\
\sum_{n=1}^{4} \texttt{arr}[i] = (1 + 6 + 4 + 2 + 5) - (1) = 18 - 1 = 17.
$$

Using prefix sums:

$$
\texttt{prefixSum}[5] - \texttt{prefixSum}[1] = 18 - 1 = 17.
$$

> Read more at: https://usaco.guide/silver/prefix-sums

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

| Time complexity  | Space complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |

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
