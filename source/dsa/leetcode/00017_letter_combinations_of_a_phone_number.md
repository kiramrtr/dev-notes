# 17. Letter Combinations of a Phone Number

```{code-block} java
class Solution {
  private static final String[] map = {
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs", // 7
    "tuv", // 8
    "wxyz", // 9
  };
  private List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return result;
    }

    backtrack(digits, new StringBuilder(), 0);
    return result;
  }

  private void backtrack(String digits, StringBuilder prefix, int index) {
    if (prefix.length() == digits.length()) {
      result.add(prefix.toString());
      return;
    }

    // - '2' is to offset the map array
    for (char c : map[digits.charAt(index) - '2'].toCharArray()) {
      prefix.append(c);
      backtrack(digits, prefix, index + 1);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
}
```
