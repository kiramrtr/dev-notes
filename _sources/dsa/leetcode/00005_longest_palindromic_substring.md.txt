# 5. Longest Palindromic Substring

```{code-block} java
:linenos:

class Solution {
  int left = 0;
  int maxLength = 0;

  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }

    for (int i = 0; i < s.length() - 1; ++i) {
      extend(s, i, i);
      extend(s, i, i + 1);
    }

    return s.substring(left, left + maxLength);
  }

  private void extend(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }

    if (r - l - 1 > maxLength) {
      maxLength = r - l - 1;
      left = l + 1;
    }
  }
}

```
