package 그래프;

import java.util.*;

public class 최단거리 {
  public int bfs(int start, List<List<Integer>> graph, boolean[] visited, int end) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{start, 0});
    visited[start] = true;

    while (!queue.isEmpty()) {  
      int[] cur = queue.poll();
      if (cur[0] == end) return cur[1];
      for (int next : graph.get(cur[0])) {
        if (!visited[next]) {
          queue.offer(new int[]{next, cur[1] + 1});
          visited[next] = true;
        }
      }
    }
    return 0;
  }
  public static void main(String[] args) {
    
  }
  
}
