# 155. Min Stack

> Courtesy: [fishercoder1534](https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_155.java)

## Approach 1

Using a `min` variable to store the current minimum value. While pushing

### Code

```{code-block} java
:linenos:

class MinStack {

  Stack<Integer> stk;
  int min;

  public MinStack() {
    stk = new Stack<>();
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    if (val <= min) {
      stk.push(min);
      min = val;
    }
    stk.push(val);
  }

  public void pop() {
    if (min == stk.pop()) {
      min = stk.pop();
    }
  }

  public int top() {
    return stk.peek();
  }

  public int getMin() {
    return min;
  }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
