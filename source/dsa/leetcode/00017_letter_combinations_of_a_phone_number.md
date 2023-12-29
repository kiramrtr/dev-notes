# [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## Iterative Approach

```{code-block} java
:linenos:
:emphasize-lines: 6,7,10,13,16

class Solution {

  public List<String> letterCombinations(String digits) {
    String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> current = new ArrayList<>();
    current.add("");

    for (char digit : digits.toCharArray()) {
      List<String> temp = new ArrayList<>();
      for (char digitChar : map[digit - '2'].toCharArray()) {
        for (String c : current) {
          temp.add(c + digitChar);
        }
      }
      current = temp;
    }

    return current.size() == 1 ? new ArrayList<String>() : current;
  }
}
```

## Recursion Approach

```{code-block} java
:linenos:
:emphasize-lines: 26

class Solution {

  private static String[] map = {
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz",
  };

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    if (digits.length() == 1) {
      return Arrays.asList(map[digits.charAt(0) - '2'].split(""));
    }

    List<String> firstCharMap = Arrays.asList(
      map[digits.charAt(0) - '2'].split("")
    );
    List<String> restCharMap = letterCombinations(digits.substring(1));

    List<String> result = new ArrayList<>();

    for (String a : firstCharMap) {
      for (String b : restCharMap) {
        result.add(a + b);
      }
    }

    return result;
  }
}
```

## Backtracking Approach

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
