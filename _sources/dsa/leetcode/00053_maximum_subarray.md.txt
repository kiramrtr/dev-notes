# 53. Maximum Subarray

## Code

::::{tab-set}

:::{tab-item} Brute-force

```{code-block} java
public int maxSubArray(int[] nums) {
  int maxSum = Integer.MIN_VALUE;

  for (int i = 0; i < nums.length; i++) {
    int sum = 0;
    for (int j = i; j < nums.length; j++) {
      sum += nums[j];
      maxSum = Math.max(sum, maxSum);
    }
  }

  return maxSum;
}
```

|  Time complexity   | Space complexity |
| :----------------: | :--------------: |
| $\mathcal{O}(n^2)$ | $\mathcal{O}(1)$ |

:::

:::{tab-item} Kaden's Algorithm

```{code-block} java
public int maxSubArray(int[] nums) {
  int maxSum = Integer.MIN_VALUE;

  // not Integer.MIN_VALUE as adding nums[i] may underflow
  int currentSum = 0;

  for (int num : nums) {
    // if current element is greater than currentSum + num
    // start new sub-array
    currentSum = Math.max(num, currentSum + num);

    // update max sum
    maxSum = Math.max(maxSum, currentSum);
  }

  return maxSum;
}
```

| Time complexity  | Space complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |

:::

::::
