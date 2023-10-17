# 226. Invert Binary Tree

::::{tab-set}

:::{tab-item} Recursion

```{code-block} java
:linenos:
:dedent: 2

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;

    TreeNode tmpLeft = root.left;
    root.left = root.right;
    root.right = tmpLeft;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
```

:::

:::{tab-item} Stack

```{code-block} java
:linenos:
:dedent: 2

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;

    Stack<TreeNode> stk = new Stack<>();
    stk.push(root);

    while (!stk.isEmpty()) {
      TreeNode currentNode = stk.pop();

      TreeNode tmpLeft = currentNode.left;
      currentNode.left = currentNode.right;
      currentNode.right = tmpLeft;

      if (currentNode.left != null) stk.push(currentNode.left);
      if (currentNode.right != null) stk.push(currentNode.right);
    }

    return root;
  }
```

:::

::::
