# 217. Contains Duplicate

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

Example 1:

> Input: nums = `[1,2,3,1]`
>
> Output: `true`

Example 2:

> Input: nums = `[1,2,3,4]`
>
> Output: `false`

## Approach

Loop over the array and add check whether `Set` already contains the element, if so duplicate exists else, add to `Set` and continue. If loop is finished it means no duplicate element exists.

## Code

```{code-block} java
public boolean containsDuplicate(int[] nums) {
  Set<Integer> set = new HashSet<Integer>();

  for (int num : nums) {
    if (set.contains(num)) {
      return true;
    }
    set.add(num);
  }
  return false;
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(n)$ |
