# [2716. Minimize String Length](https://leetcode.com/problems/minimize-string-length/)

**Approach**

As given string contains only lowercase english letters, we can have an array of size 26 and keeping track of the count and counting characters not seen already.

```{code-block} java
:linenos:

public int minimizedStringLength(String s) {
  int[] charCount = new int[26];
  int length = 0;

  for (int i = 0; i < s.length(); i++) {
    if (charCount[s.charAt(i) - 'a'] == 0) {
      charCount[s.charAt(i) - 'a']++;
      length++;
    }
  }

  return length;
}
```
