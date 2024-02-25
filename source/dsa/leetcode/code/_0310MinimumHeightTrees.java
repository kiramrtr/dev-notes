// 310. Minimum Height Trees
package source.dsa.leetcode.code;

import java.util.*;

public class _0310MinimumHeightTrees {

  public static void main(String[] args) {
    _0310MinimumHeightTrees p = new _0310MinimumHeightTrees();
    Solution s = p.new Solution();
    int[][] input = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
    List<Integer> result = s.findMinHeightTrees(4, input);
    System.out.println("result: " + result);
  }

  class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (edges.length == 0) {
        return List.of(0);
      }
      Map<Integer, Set<Integer>> graph = buildGraph(edges);

      List<Integer> result = new LinkedList<>();
      for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
        if (entry.getValue().size() == 1) {
          result.add(entry.getKey());
        }
      }

      while (n > 2) {
        n -= result.size();
        List<Integer> nextLeaves = new LinkedList<>();
        for (final int leaf : result) {
          final int leafNextNode = graph.get(leaf).iterator().next();
          graph.get(leafNextNode).remove(leaf);
          if (graph.get(leafNextNode).size() == 1) {
            nextLeaves.add(leafNextNode);
          }
        }
        result = nextLeaves;
      }
      return result;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
      Map<Integer, Set<Integer>> graph = new HashMap<>();
      for (int[] edge : edges) {
        final int u = edge[0];
        final int v = edge[1];

        graph.computeIfAbsent(u, s -> new HashSet<>());
        graph.get(u).add(v);

        graph.computeIfAbsent(v, s -> new HashSet<>());
        graph.get(v).add(u);
      }

      return graph;
    }
  }
}
