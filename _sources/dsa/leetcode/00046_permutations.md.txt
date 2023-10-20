# [46. Permutations](https://leetcode.com/problems/permutations/)

```{code-block} java
:linenos:

public List<List<Integer>> permute(int[] nums) {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> path = new ArrayList<>();
  boolean[] used = new boolean[nums.length];

  backtrack(nums, result, path, used);

  return result;
}

private void backtrack(
  int[] nums,
  List<List<Integer>> result,
  List<Integer> path,
  boolean[] used
) {
  if (path.size() == nums.length) {
    result.add(List.copyOf(path));
  }

  for (int i = 0; i < nums.length; i++) {
    if (!used[i]) {
      path.add(nums[i]);
      used[i] = true;
      backtrack(nums, result, path, used);
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }
}
```

|  Time Complexity  | Space Complexity |
| :---------------: | :--------------: |
| $\mathcal{O}(n!)$ | $\mathcal{O}(n)$ |
