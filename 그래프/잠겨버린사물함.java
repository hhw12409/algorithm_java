package 그래프;

import java.util.ArrayDeque;
import java.util.Queue;

// 체육관의 락커룸에서 누군가 장난을 쳤습니다! 모든 락커를 잠가버리고, 각 락커 안에 다른 락커를 열 수 있는 열쇠를 숨겨 놓았습니다.
// 0번 락커는 다행히 처음부터 열려 있어 사용할 수 있지만, 나머지 락커는 해당 락커의 열쇠를 찾아야만 열 수 있습니다.
// lockers[i]는 i번 락커 안에 들어 있는 열쇠들의 목록을 나타냅니다.
// 모든 열쇠를 사용해도 열 수 없는 락커의 개수를 반환하는 solution 함수를 작성하세요.
// https://cote.nossi.dev/problem/27/description
public class 잠겨버린사물함 {
  public int solution(int[][] lockers) {
    int n = lockers.length;
    boolean[] visited = new boolean[n];
    int answer = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next: lockers[cur]) {
        if (!visited[next]) {
          queue.add(next);
          visited[next] = true;
        }
      }
    }
    for (boolean isVisited : visited) {
      if (!isVisited) answer++;
    }

    return answer;
  }

  public int solution2(int[][] lockers) {
    int n = lockers.length;
    boolean[] visited = new boolean[n];

    int count = dfs(0, lockers, visited);

    return n - count;
  }

  int dfs(int cur, int[][] lockers, boolean[] visited) {
    int count = 0;
    visited[cur] = true;
    for (int next : lockers[cur]) {
      if (!visited[next]) {
        count += dfs(next, lockers, visited);
      }
    }
    return count;
  }
  public static void main(String[] args) {
  
 } 
}
