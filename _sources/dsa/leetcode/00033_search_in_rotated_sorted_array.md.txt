# 33. Search in Rotated Sorted Array

```{code-block} java
:linenos:

class Solution {

  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (target > nums[mid] || target < nums[left]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (target < nums[mid] || target > nums[right]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }

    return -1;
  }
}
```

|    Time Complexity     | Space Complexity |
| :--------------------: | :--------------: |
| $\mathcal{O}(\log{n})$ | $\mathcal{O}(1)$ |
