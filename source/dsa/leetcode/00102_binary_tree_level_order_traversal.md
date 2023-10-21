# [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

## Approach 1 - Recursion

```{code-block} java
:linenos:
:dedent: 2

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> resultList = new ArrayList<>();

    if (root == null) {
      return resultList;
    }

    List<Integer> rootLevelList = new ArrayList<>();
    rootLevelList.add(root.val);

    resultList.add(0, rootLevelList);

    levelOrder(root.left, resultList, 1);
    levelOrder(root.right, resultList, 1);

    return resultList;
  }

  private void levelOrder(
    TreeNode currentRoot,
    List<List<Integer>> list,
    int level
  ) {
    if (currentRoot == null) {
      return;
    }

    if (list.size() - 1 < level) {
      list.add(level, new ArrayList<Integer>());
    }

    List<Integer> levelList = list.get(level);
    levelList.add(currentRoot.val);

    levelOrder(currentRoot.left, list, level + 1);
    levelOrder(currentRoot.right, list, level + 1);
  }
```

## Approach 2 - BFS

```{code-block} java
:linenos:
:dedent: 2

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int nodesCount = q.size();
      List<Integer> nodesInLevel = new ArrayList<>();

      for (int i = 0; i < nodesCount; i++) {
        if (q.peek().left != null) {
          q.offer(q.peek().left);
        }

        if (q.peek().right != null) {
          q.offer(q.peek().right);
        }

        nodesInLevel.add(q.poll().val);
      }
      result.add(nodesInLevel);
    }

    return result;
  }
```
