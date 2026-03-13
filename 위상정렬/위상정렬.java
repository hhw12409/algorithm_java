package 위상정렬;

import java.util.*;

public class 위상정렬 {
  public int[] topologicalSort(int nodesNum, int[][] edges) {
    // 주어진 입력을 사용하기 편한 형태로 변경 -> 방향그래프로 변경
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[nodesNum];
    // edges의 원소 [v, u]는 u -> v 의 방향을 가지 edge를 뜻한다.
    for (int[] edge : edges) {
      graph.putIfAbsent(edge[1], new ArrayList<>());
      graph.get(edge[1]).add(edge[0]);
      indegree[edge[0]]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    int[] order = new int[nodesNum];
    // 위상정렬을 수행한다.
    // indegree == 0 인 정점부터 탐색이 시작된다.
    int count = 0;
    for (int c = 0; c < nodesNum; c++) {
      if (indegree[c] == 0) {
        queue.add(c);
        order[count] = c;
        count++;
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.remove();

      if (graph.containsKey(cur)) {
        // 해당 정점과 연결된 노드들의 진입차수에서 1빼기
        for (int next : graph.get(cur)) {
          indegree[next]--;
          // 진입차수가 0이면 이제 방문해도 된다는 뜻이기 때문에 queue에 추가해준다.
          if (indegree[next] == 0) {
            order[count] = next;
            count++;
            queue.add(next);
          }
        }
      }
    }
    return order;
  }
}
