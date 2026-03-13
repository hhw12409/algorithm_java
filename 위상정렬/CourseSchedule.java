package 위상정렬;

import java.util.*;

public class CourseSchedule {
  public boolean solution(int numCourses, int[][] prerequisites) {
    // 주어진 입력을 사용하기 편한 형태로 변경하기 -> 방향 그래프로 변경
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] edge : prerequisites) {
      graph.putIfAbsent(edge[1], new ArrayList<>());
      graph.get(edge[1]).add(edge[0]);
      // 그 과정 중 indegree 기록하기
      indegree[edge[0]]++;
    }

    // 위상정렬을 수행한다.
    Queue<Integer> queue = new ArrayDeque<>();
    int count = 0;
    // 진입차수가 0인 노드(초기 노드)들을 큐에 넣는다.
    for (int c = 0; c < numCourses; c++) {
      if (indegree[c] == 0) {
        queue.add(c);
        count++;
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.remove();
      
      if (graph.containsKey(cur)) {
        for (int next : graph.get(cur)) {
          // 해당 정점과 연결된 노드들에서 진입차수를 뺀다.
          indegree[next]--;
          // 진입차수가 0이 되었다면 방문한다.
          if (indegree[next] == 0) {
            count++;
            queue.add(next);
          }
        }
      }
    }
    // 위상정렬 수행 후 들은 과목수와 numCourse가 같은지를 반환한다.
    // 사이클이 존재한다면 모든 과목을 방문하지 못하는 것이기 때문에 numCourse와 다르다.
    return count == numCourses;
  }
}
