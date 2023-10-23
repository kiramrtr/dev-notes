# 278. First Bad Version

**Approach/Intuition**

Binary Search

```{code-block} java
:linenos:
:dedent: 2

  public int firstBadVersion(int n) {
    int left = 0;
    int right = n;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
```
