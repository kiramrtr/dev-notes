# 543. Diameter of Binary Tree

```{code-block} java
:linenos:

class Solution {
  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return diameter;
  }

  private int helper(TreeNode node) {
    if (node == null) { return 0; }

    int left = helper(node.left);
    int right = helper(node.right);

    // update diameter if it has max from current node
    diameter = Math.max(diameter, (left + right));

    // returning for higher-level
    return Math.max(left, right) + 1;
  }
}
```
