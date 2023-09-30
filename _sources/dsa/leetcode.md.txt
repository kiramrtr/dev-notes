# LeetCode

## 2716. Minimize String Length

```java
class Solution {

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
}
```
