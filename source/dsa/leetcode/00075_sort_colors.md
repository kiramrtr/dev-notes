# 75. Sort Colors

```{code-block} java
:linenos:
:dedent: 2

  public void sortColors(int[] nums) {
    int lowEnd = 0, midEnd = 0;
    int highStart = nums.length - 1;

    while (midEnd <= highStart) {
      if (nums[midEnd] == 0) {
        swap(nums, midEnd++, lowEnd++);
      } else if (nums[midEnd] == 1) {
        midEnd++;
      } else if (nums[midEnd] == 2) {
        swap(nums, midEnd, highStart--);
      }
    }
  }

  private void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
```
