# [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

::::{tab-set}

:::{tab-item} Brute-force

```{code-block} java
---
emphasize-lines: 7-8
---
private int subarraySum(int[] nums, int k) {
  int count = 0;
  for (int i = 0; i < nums.length; i++) {
    int sum = 0;

    for (int j = i; j < nums.length; j++) {
      sum += nums[j];
      if (sum == k) count++;
    }
  }
  return count;
}
```

|  Time complexity   | Space complexity |
| :----------------: | :--------------: |
| $\mathcal{O}(n^2)$ | $\mathcal{O}(1)$ |

:::

:::{tab-item} Prefix Sum + Hash Table

Read about [Prefix Sum](../algorithmic-techniques)

```{code-block} java
---
emphasize-lines: 5,6,10,12
---

private int subarraySum(int[] nums, int k) {
  int count = 0;

  // map: prefixSum -> frequency
  Map<Integer, Integer> map = new HashMap<>();
  map.put(0, 1); // 0 prefixSum

  int sum0toi = 0;
  for (int i = 0; i < nums.length; i++) {
    sum0toi += nums[i];

    int sum0toj = sum0toi - k;

    if (map.containsKey(sum0toj)) {
      count = count + map.get(sum0toj);
    }
    map.put(sum0toi, map.getOrDefault(sum0toi, 0) + 1);
  }
  return count;
}
```

| Time complexity  | Space complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(n)$ |

:::

::::
