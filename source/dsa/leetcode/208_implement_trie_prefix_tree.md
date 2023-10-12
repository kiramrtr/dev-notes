# [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

::::{tab-set}

:::{tab-item} HashMap

```{code-block} java
class Trie {

  private class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean terminal;
  }

  private Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node currentNode = root;
    for (char ch : word.toCharArray()) {
      if (currentNode.children.get(ch) == null) {
        currentNode.children.put(ch, new Node());
      }
      currentNode = currentNode.children.get(ch);
    }
    currentNode.terminal = true;
  }

  public boolean search(String word) {
    Node currentNode = root;
    for (char ch : word.toCharArray()) {
      if (currentNode.children.get(ch) == null) {
        return false;
      }
      currentNode = currentNode.children.get(ch);
    }
    return currentNode.terminal;
  }

  public boolean startsWith(String prefix) {
    Node currentNode = root;
    for (char ch : prefix.toCharArray()) {
      if (currentNode.children.get(ch) == null) {
        return false;
      }
      currentNode = currentNode.children.get(ch);
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

:::

:::{tab-item} Array

```{code-block} java
class Trie {

  private class Node {
    Node[] children = new Node[26];
    boolean terminal;
  }

  private Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node currentNode = root;
    for (char ch : word.toCharArray()) {
      int position = ch - 'a';
      if (currentNode.children[position] == null) {
        currentNode.children[position] = new Node();
      }
      currentNode = currentNode.children[position];
    }
    currentNode.terminal = true;
  }

  public boolean search(String word) {
    Node currentNode = root;
    for (char ch : word.toCharArray()) {
      int position = ch - 'a';
      if (currentNode.children[position] == null) {
        return false;
      }
      currentNode = currentNode.children[position];
    }
    return currentNode.terminal;
  }

  public boolean startsWith(String prefix) {
    Node currentNode = root;
    for (char ch : prefix.toCharArray()) {
      int position = ch - 'a';
      if (currentNode.children[position] == null) {
        return false;
      }
      currentNode = currentNode.children[position];
    }
    return true;
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

:::

::::
