# 242. Valid Anagram

## Approach 1: Keeping Count Array

```{code-block} java
:linenos:
:dedent: 2

  public boolean isAnagram(String s, String t) {
    int[] charCount = new int[26];

    for (char c : s.toCharArray()) {
      charCount[c - 'a']++;
    }

    for (char c : t.toCharArray()) {
      charCount[c - 'a']--;
    }

    for (int count : charCount) {
      if (count != 0) return false;
    }

    return true;
  }
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |

## Approach 2: Sorting

```{code-block} java
:linenos:
:dedent: 2

  public boolean isAnagram(String s, String t) {
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();

    Arrays.sort(sArray);
    Arrays.sort(tArray);

    return Arrays.compare(sArray, tArray) == 0;
  }
```

|   Time Complexity    | Space Complexity |
| :------------------: | :--------------: |
| $\mathcal{O}(nlogn)$ | $\mathcal{O}(n)$ |
