# 409. Longest Palindrome

**Intuition**

```{image} images/409-Longest-Palindrome-Set-Intuition.png
:align: center
```

> Source: [Yao Frankie](https://leetcode.com/problems/longest-palindrome/solutions/89604/simple-hashset-solution-java/comments/474116)

```{code-block} java
:linenos:
:dedent: 2

  public int longestPalindrome(String s) {
    Set<Character> set = new HashSet<>();
    int pairsCount = 0;

    for (char c : s.toCharArray()) {
      if (set.remove(c)) {
        // if character exists remove and add to pairsCount
        pairsCount++;
      } else {
        set.add(c);
      }
    }

    return (pairsCount * 2) + (set.isEmpty() ? 0 : 1);
  }
```
