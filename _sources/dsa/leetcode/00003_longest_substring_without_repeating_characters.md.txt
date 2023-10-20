# 3. Longest Substring Without Repeating Characters

**Approach:**
Sliding Window with a `Set` holding the unique characters

```{code-block} java
:linenos:
:dedent: 2

  public int lengthOfLongestSubstring(String s) {
    int max = 0, left = 0, right = 0;
    Set<Character> charsInWindow = new HashSet<>();

    while (right < s.length()) {
      if (charsInWindow.contains(s.charAt(right))) {
        charsInWindow.remove(s.charAt(left));
        left++;
      } else {
        charsInWindow.add(s.charAt(right));
        right++;
        max = Math.max(max, charsInWindow.size());
      }
    }

    return max;
  }
```
