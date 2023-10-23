# 70. Climbing Stairs

```{code-block} java
:linenos:
:dedent: 2

  public int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int first = 1;
    int second = 2;
    int third = first + second;

    for (int i = 3; i <= n; i++) {
      third = first + second;

      first = second;
      second = third;
    }

    return third;
  }
```
