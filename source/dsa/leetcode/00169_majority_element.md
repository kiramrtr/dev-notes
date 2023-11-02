# 169. Majority Element

## Brute-force

```{code-block} java
:linenos:

public int majorityElement(int[] nums) {
  int size = nums.length / 2;

  for (int i = 0; i < nums.length; i++) {
    int occurences = 0;

    for (int j = 0; j < nums.length; j++) {
      if (nums[i] == nums[j]) {
        occurences++;
      }
    }

    if (occurences > size) {
      return nums[i];
    }
  }

  return -1;
}
```

## Using HashMap

```{code-block} java
:linenos:

public int majorityElement(int[] nums) {
  Map<Integer, Integer> count = new HashMap<>();
  int n = nums.length / 2;

  for (int num : nums) {
    int currentCount = count.merge(num, 1, Integer::sum);
    if (currentCount > n) {
      return num;
    }
  }
  return -1;
}
```

## Boyer–Moore majority vote algorithm

```{code-block} java
:linenos:

public int majorityElement(int[] nums) {
  int count = 0;
  int result = -1;

  for (int i = 0; i < nums.length; i++) {
    if (count == 0) result = nums[i];

    if (nums[i] == result) {
      count++;
    } else {
      count--;
    }
  }

  return result;
}
```
