# JP Morgan (All time)

## [202. Happy Number](https://leetcode.com/problems/happy-number)

{bdg-success}`Easy`

```{code-block} java
:linenos:

class Solution {

  public boolean isHappy(int n) {
    int slow = squaredSum(n);
    int fast = squaredSum(squaredSum(n));

    while (slow != fast) {
      slow = squaredSum(slow);
      fast = squaredSum(squaredSum(fast));
    }

    return slow == 1;
  }

  private int squaredSum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += Math.pow(n % 10, 2);
      n /= 10;
    }
    return sum;
  }
}
```

## [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses)

{bdg-success}`Easy`

```{code-block} java
:linenos:

class Solution {

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (final char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
```

## [322. Coin Change](https://leetcode.com/problems/coin-change)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

class Solution {

  public int coinChange(int[] coins, int amount) {
    // dp[i] := the minimum number of coins to make up i
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, 1, dp.length, amount + 1);

    for (final int coin : coins) {
      for (int i = coin; i <= amount; ++i) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
}
```

## [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [1328. Break a Palindrome](https://leetcode.com/problems/break-a-palindrome)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [31. Next Permutation](https://leetcode.com/problems/next-permutation)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [273. Integer to English Words](https://leetcode.com/problems/integer-to-english-words)

{bdg-danger}`Hard`

```{code-block} java
:linenos:

```

## [9. Palindrome Number](https://leetcode.com/problems/palindrome-number)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [1. Two Sum](https://leetcode.com/problems/two-sum)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [7. Reverse Integer](https://leetcode.com/problems/reverse-integer)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [200. Number of Islands](https://leetcode.com/problems/number-of-islands)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)

{bdg-danger}`Hard`

```{code-block} java
:linenos:

```

## [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [146. LRU Cache](https://leetcode.com/problems/lru-cache)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [79. Word Search](https://leetcode.com/problems/word-search)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [39. Combination Sum](https://leetcode.com/problems/combination-sum)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string)

{bdg-success}`Easy`

```{code-block} java
:linenos:

```

## [1247. Minimum Swaps to Make Strings Equal](https://leetcode.com/problems/minimum-swaps-to-make-strings-equal)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

```

## [2038. Remove Colored Pieces if Both Neighbors are the Same Color](https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color)

{bdg-warning}`Medium`

```{code-block} java
:linenos:

class Solution {

  public boolean winnerOfGame(String colors) {
    int aTripletsCount = 0;
    int bTripletsCount = 0;

    for (int i = 1; i + 1 < colors.length(); ++i) {
      if (
        colors.charAt(i - 1) == colors.charAt(i) &&
        colors.charAt(i) == colors.charAt(i + 1)
      ) {
        if (colors.charAt(i) == 'A') {
          aTripletsCount++;
        } else {
          bTripletsCount++;
        }
      }
    }

    return aTripletsCount > bTripletsCount;
  }
}
```
