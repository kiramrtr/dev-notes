# [78. Subsets](https://leetcode.com/problems/subsets/)

Given an integer array `nums` of **unique** elements, return all possible subsets (the power set).

The solution set **must not** contain duplicate subsets. Return the solution in **any order**.

Example 1:

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

Example 2:

```
Input: nums = [0]
Output: [[],[0]]
```

```{code-block} java
:linenos:

class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    dfs(nums, 0, new ArrayList<>(), allSubsets);
    return allSubsets;
  }

  private void dfs(
    int[] nums,
    int start,
    List<Integer> currentSubset,
    List<List<Integer>> allSubsets
  ) {
    allSubsets.add(new ArrayList<>(currentSubset));
    for (int i = start; i < nums.length; ++i) {
      currentSubset.add(nums[i]);
      dfs(nums, i + 1, currentSubset, allSubsets);
      currentSubset.remove(currentSubset.size() - 1);
    }
  }
}
```

Call stack for input `[1, 2, 3]`

```
>> dfs(start: 0, currentSubset: [])
    >> dfs(start: 1, currentSubset: [1])
        >> dfs(start: 2, currentSubset: [1, 2])
            >> dfs(start: 3, currentSubset: [1, 2, 3])
        >> dfs(start: 3, currentSubset: [1, 3])
    >> dfs(start: 2, currentSubset: [2])
        >> dfs(start: 3, currentSubset: [2, 3])
    >> dfs(start: 3, currentSubset: [3])
```

|  Time Complexity   |  Space Complexity  |
| :----------------: | :----------------: |
| $\mathcal{O}(2^n)$ | $\mathcal{O}(2^n)$ |
