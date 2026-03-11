package 그래프;

import java.util.*;

// O(V + E)
public class DFS {
  void solution(List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    dfs(0, graph, visited);
  }

  void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
    // 방문
    visited[cur] = true;
    // 방문안한 다음 노드 찾기
    for (int next : graph.get(cur)) {
      // 다음 노드 DFS 실행
      if (!visited[cur]) {
        dfs(next, graph, visited);
      }
    }
  }
}
