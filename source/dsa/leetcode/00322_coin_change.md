# 322. Coin Change

## Recursion with Memoization

```{code-block} java
:linenos:

class Solution {
  private Map<Integer, Integer> memo = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    return dp(coins, amount);
  }

  private int dp(int[] coins, int n) {
    if (memo.containsKey(n)) return memo.get(n);

    if (n == 0) return 0;
    if (n < 0) return -1;

    int res = Integer.MAX_VALUE;

    for (int coin : coins) {
      int subProblem = dp(coins, n - coin);
      if (subProblem == -1) continue;
      res = Math.min(res, 1 + subProblem);
    }

    memo.put(n, (res == Integer.MAX_VALUE ? -1 : res));
    return memo.get(n);
  }
}
```

## DP

```{code-block} java
:linenos:

public int coinChange(int[] coins, int amount) {
  int[] dp = new int[amount + 1];

  for (int i = 0; i < dp.length; ++i) {
    dp[i] = amount + 1;
  }

  dp[0] = 0;
  for (int i = 0; i < dp.length; ++i) {
    for (int coin : coins) {
      if (i - coin < 0) {
        continue;
      }
      dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
    }
  }

  return dp[amount] == amount + 1 ? -1 : dp[amount];
}
```
