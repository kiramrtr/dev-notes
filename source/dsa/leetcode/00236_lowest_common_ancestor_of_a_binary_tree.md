# 236. Lowest Common Ancestor of a Binary Tree

```{code-block} java
:linenos:
:dedent: 2

  private TreeNode ans = null;

  private boolean lca(TreeNode currentNode, TreeNode p, TreeNode q) {
    if (currentNode == null) return false;

    int curr = (currentNode == p || currentNode == q) ? 1 : 0;
    int left = lca(currentNode.left, p, q) ? 1 : 0;
    int right = lca(currentNode.right, p, q) ? 1 : 0;

    if ((left + curr + right) > 1) {
      ans = currentNode;
    }

    return (left + curr + right) > 0;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    lca(root, p, q);
    return ans;
  }
```

```{code-block} java
:linenos:
:dedent: 2

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return left == null ? right : left;
  }
```
