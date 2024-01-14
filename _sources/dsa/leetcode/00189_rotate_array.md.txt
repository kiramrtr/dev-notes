# [189. Rotate Array](https://leetcode.com/problems/rotate-array/)

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

Example

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

## Approach 1: Doing k rotations one by one

```{code-block} java
:linenos:
:emphasize-lines: 7

class Solution {

  public void rotate(int[] nums, int k) {
    final int n = nums.length;
    if (n < 0) return;

    k = k % n;
    int rotationNo = 1;
    while (rotationNo <= k) {
      final int lastElement = nums[n - 1];
      for (int i = n - 1; i > 0; --i) {
        nums[i] = nums[i - 1];
      }
      nums[0] = lastElement;
      ++rotationNo;
    }
  }
}
```

## Approach 2: By Reversing

Input $[1, 2, 3, 4, 5, 6, 7]$ with length $n = 7$. Rotate by $k = 3$ steps to the right

1. Rotate entire array from $0 \to n-1 \implies [7, 6, 5, 4, 3, 2, 1]$
2. Rotate from $0 \to k-1 \implies [5, 6, 7, 4, 3, 2, 1]$
3. Rotate from $k \to n-1 \implies [5, 6, 7, 1, 2, 3, 4]$

```{code-block} java

class Solution {

  public void rotate(int[] nums, int k) {
    if (nums.length == 0) return;

    k = k % nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) swap(arr, start++, end--);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
```

## Approach 3: Using block-swap algorithm
