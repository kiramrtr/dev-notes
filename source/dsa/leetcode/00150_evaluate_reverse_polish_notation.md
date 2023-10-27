# 150. Evaluate Reverse Polish Notation

```{code-block} java
:linenos:
:dedent: 2

  public int evalRPN(String[] tokens) {
    Stack<Integer> stk = new Stack<>();

    for (String token : tokens) {
      if (token.equals("+")) {
        int b = stk.pop();
        int a = stk.pop();

        stk.push(a + b);
      } else if (token.equals("-")) {
        int b = stk.pop();
        int a = stk.pop();

        stk.push(a - b);
      } else if (token.equals("*")) {
        int b = stk.pop();
        int a = stk.pop();

        stk.push(a * b);
      } else if (token.equals("/")) {
        int b = stk.pop();
        int a = stk.pop();

        stk.push(a / b);
      } else {
        stk.push(Integer.parseInt(token));
      }
    }

    return stk.pop();
  }
```
