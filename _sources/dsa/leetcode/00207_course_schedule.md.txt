# 207. Course Schedule

```{code-block} java
:linenos:

class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] adjList = new ArrayList[numCourses];

    for (int i = 0; i < numCourses; ++i) {
      adjList[i] = new ArrayList<>();
    }

    for (int[] prereq : prerequisites) {
      adjList[prereq[1]].add(prereq[0]);
    }

    boolean[] visited = new boolean[numCourses];
    boolean[] completed = new boolean[numCourses];

    for (int i = 0; i < numCourses; ++i) {
      if (hasCycle(i, adjList, visited, completed)) {
        return false;
      }
    }

    return true;
  }

  private boolean hasCycle(
    int i,
    List<Integer>[] adjList,
    boolean[] visited,
    boolean[] completed
  ) {
    if (completed[i]) return false;

    visited[i] = true;
    for (int n : adjList[i]) {
      if (visited[n] || hasCycle(n, adjList, visited, completed)) {
        return true;
      }
    }
    visited[i] = false;
    completed[i] = true;

    return false;
  }
}
```
