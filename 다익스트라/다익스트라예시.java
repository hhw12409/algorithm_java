package 다익스트라;

import java.util.*;

public class 다익스트라예시 {

  // 간선 (목적지, 가중치)
  static class Edge {
    int to;
    int distance;
    Edge(int to, int distance) {
      this.to = to;
      this.distance = distance;
    }
  }

  // 우선순위 큐 항목 (노드, 현재까지의 거리)
  static class Entry implements Comparable<Entry> {
    int node;
    int distance;
    Entry(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
    @Override
    public int compareTo(Entry o) {
      return this.distance - o.distance;
    }
  }

  private static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int n) {
    final int INF = Integer.MAX_VALUE;
    int[] distance = new int[n + 1];
    Arrays.fill(distance, INF);

    PriorityQueue<Entry> pq = new PriorityQueue<>();
    pq.add(new Entry(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
      Entry current = pq.remove();
      if (distance[current.node] < current.distance) continue;

      for (Edge edge : graph.get(current.node)) {
        int newDist = current.distance + edge.distance;
        if (newDist < distance[edge.to]) {
          distance[edge.to] = newDist;
          pq.add(new Entry(edge.to, newDist));
        }
      }
    }
    return distance[end];
  }

  public static void main(String[] args) {
    // 예시 그래프
    // 1 --(2)--> 2 --(3)--> 4
    // 1 --(6)--> 3 --(1)--> 4
    int n = 4;
    Map<Integer, List<Edge>> graph = new HashMap<>();
    for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());

    graph.get(1).add(new Edge(2, 2));
    graph.get(1).add(new Edge(3, 6));
    graph.get(2).add(new Edge(4, 3));
    graph.get(3).add(new Edge(4, 1));

    int result = dijkstra(graph, 1, 4, n);
    System.out.println("1 -> 4 최단거리: " + result); // 5
  }
}
