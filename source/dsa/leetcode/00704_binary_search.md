# 704. Binary Search

```{code-block} java
:linenos:
:dedent: 1
:emphasize-lines: 5,6,11,13

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    return -1;
  }
```

- line no. 5: `<=` because we are taking right as `nums.length - 1`
- line no. 6: `left + (right - left) / 2` instead of `(left + right) / 2` for avoiding overflow.
- line no. 11: `mid + 1` as `mid` has been checked already.
- line no. 13: `mid - 1` as `mid` has been checked already.
