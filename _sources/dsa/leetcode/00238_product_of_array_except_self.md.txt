# 238. Product of Array Except Self

## Approach

|            `i` |   0 |      1 | 2   | 3   |
| -------------: | --: | -----: | --- | --- |
|         `nums` |   1 |      2 | 3   | 4   |
|  `leftProduct` |   1 |  **1** | 2   | 6   |
| `rightProduct` |  24 | **12** | 4   | 1   |
|          `ans` |  24 | **12** | 8   | 6   |

Product expect self is product of `leftProduct` and `rightProduct`. Instead of computing `leftProduct` and `rightProduct` and then computing `ans`. Compute `leftProduct` and while computing `rightProduct`, computer `ans` too.

## Code

```{code-block} java
:linenos:
:dedent: 2

  public int[] productExceptSelf(int[] nums) {
    int res[] = new int[nums.length];

    int leftProduct = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = leftProduct;
      leftProduct *= nums[i];
    }

    int rightProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= rightProduct;
      rightProduct *= nums[i];
    }

    return res;
  }
```
