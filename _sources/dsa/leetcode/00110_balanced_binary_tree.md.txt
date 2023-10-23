# [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

## Brute-force

```{code-block} java
:linenos:

class Solution {

  public boolean isBalanced(TreeNode root) {
    return dfsHeight(root) != -1;
  }

  private int dfsHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = dfsHeight(node.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = dfsHeight(node.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
```

|  Time Complexity   | Space Complexity |
| :----------------: | :--------------: |
| $\mathcal{O}(n^2)$ | $\mathcal{O}(1)$ |

## Optimized DFS

```{code-block} java
:linenos:

class Solution {

  public boolean isBalanced(TreeNode root) {
    return dfsHeight(root) != -1;
  }

  private int dfsHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = dfsHeight(node.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = dfsHeight(node.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |
