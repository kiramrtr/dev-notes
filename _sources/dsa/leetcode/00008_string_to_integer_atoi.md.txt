# 8. String to Integer (atoi)

```{code-block} java
:linenos:

class Solution {

  public int myAtoi(String s) {
    if (s.length() == 0) return 0;

    int startIndex = 0;
    while (
      startIndex < s.length() && Character.isWhitespace(s.charAt(startIndex))
    ) {
      startIndex++;
    }

    int sign = 1;
    if (
      startIndex < s.length() &&
      (s.charAt(startIndex) == '-' || s.charAt(startIndex) == '+')
    ) {
      sign = s.charAt(startIndex) == '-' ? -1 : 1;
      startIndex++;
    }

    long result = 0;

    for (int i = startIndex; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (!Character.isDigit(c)) {
        break;
      }

      result = result * 10 + (c - '0');

      if (sign * result <= Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      if (sign * result >= Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
    }

    return (int) (sign * result);
  }
}
```
