# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Code

```{code-block} java
:linenos:
:dedent: 2

  public boolean isValid(String s) {
    Stack<Character> stk = new Stack();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stk.push(c);
      } else if (c == ')' || c == ']' || c == '}') {
        if (stk.isEmpty()) return false;

        char top = stk.peek();
        if (
          (c == ')' && top != '(') ||
          (c == ']' && top != '[') ||
          (c == '}' && top != '{')
        ) {
          return false;
        }
        stk.pop();
      }
    }

    return stk.isEmpty();
  }
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(n)$ |
