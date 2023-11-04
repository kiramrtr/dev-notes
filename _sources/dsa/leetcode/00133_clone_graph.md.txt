# 133. Clone Graph

```{code-blokc} java
:linenos:

class Solution {
  Map<Node, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }

    if (!map.containsKey(node)) {
      map.put(node, new Node(node.val));

      for (Node neighbor : node.neighbors) {
        map.get(node).neighbors.add(cloneGraph(neighbor));
      }
    }

    return map.get(node);
  }
}
```