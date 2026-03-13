package 다익스트라;

import java.util.*;
import java.util.stream.Collectors;

// 주어진 네트워크에는 n개의 노드가 있으며, 이는 1부터 n까지 레이블이 붙어 있습니다.
// 또한 times[i] = u, v, w 리스트가 주어집니다. 이 때, u노드에서 신호를 보내서 v노드에 도달하는데 걸리는 시간을 w라고합니다.

// k노드에서 신호를 보낼 때, 모든 노드에 신호가 도달하기 위한 최소 비용을 반환하시오.
// 하나의 노드라도 도달하지 못한다면 -1을 반환 하시오 (한 노드에서 연결된 여러 개의 edge에 신호를 동시에 전달 할 수 있습니다.)

// input: times = [[2, 1, 2], [2, 3, 5], [2, 4, 1], [4, 3, 3]], n=4, k=2
// output: 4
public class NetworkDelayTime {
  public int solution(int[][] times, int n, int k) {
    // 그래프 구현
    Map<Integer, List<int[]>> graph = Arrays.stream(times)
    .collect(Collectors.groupingBy(t -> t[0]));

    // 다익스트라 알고리즘
    Map<Integer, Integer> costs = new HashMap<>();
    Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
    pq.add(new int[]{0, k});

    while (!pq.isEmpty()) {
      int[] cur = pq.remove();
      int curCost = cur[0];
      int curNode = cur[1];
      if (!costs.containsKey(curNode)) {
        costs.put(curNode, curCost);
        if (!graph.containsKey(curNode)) continue;
        for (int[] edge : graph.get(curNode)) {
          int nextCost = curCost + edge[2];
          pq.add(new int[]{nextCost, edge[1]});
        }
      }
    }
    // 방문 못한 노드 찾기
    for (int node = 1; node < n + 1; node++) {
      if (!costs.containsKey(node)) {
        return -1;
      }
    }
    // 최소값중에서 최대값 구하기
    return costs.values().stream()
    .mapToInt(Integer::intValue).max().getAsInt();
  }

  public static void main(String[] args) {
    NetworkDelayTime solution = new NetworkDelayTime();
    int[][] times = {
      {2, 1, 2},
      {2, 3, 5},
      {2, 4, 1},
      {4, 3, 3}
    };
    int result = solution.solution(times, 4, 2);
    System.out.println(result);
  }
}
