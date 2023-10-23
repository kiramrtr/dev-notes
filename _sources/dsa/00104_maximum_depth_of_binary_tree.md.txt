# 104. Maximum Depth of Binary Tree

```{code-block} java
:linenos:
:dedent: 2

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
```
