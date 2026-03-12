package 그리드;

import java.util.ArrayDeque;
import java.util.Queue;

// 하늘을 찍은 사진이 있습니다. 이 사진에는 다양한 모양의 구름들이 떠 있습니다.
// 하늘 사진은 0과 1로 이루어진 m x n 크기의 2차원 배열로 표현됩니다. 1은 구름이 있는 영역을 나타내고, 0은 하늘(빈 공간)을 의미합니다.
// 구름은 상하좌우로 인접한 1들로 이루어지며, 대각선으로 연결된 부분은 같은 구름으로 간주하지 않습니다.
// 주어진 하늘 사진 속 구름의 개수를 반환하는 함수를 작성하세요.

public class 구름의개수 {
  int[] dr = {0, 1, 0, -1};
  int[] dc = {1, 0, -1, 0};
  public int solution(int[][] sky) {
    int answer = 0;
    int n = sky.length;
    int m = sky[0].length;
    boolean[][] visited = new boolean[n][m];
  
    // 모든 요소를 순회
    for (int row = 0; row < n; row++) {
      for (int column = 0; column < m; column++) {
        // 값이 1이면서 방문을 아직 안한 경우
        if (sky[row][column] == 1 && !visited[row][column]) {
          // DFS 또는 BFS 실행
          bfs(sky, visited, row, column);
          // 개수 + 1
          answer++;
        }
      }
    }
    return answer;
  }

  void bfs(int[][] sky, boolean[][] visited, int startRow, int startColumn) {
    int n = sky.length;
    int m = sky[0].length;

    // 시작노드 예약
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{startRow, startColumn});
    visited[startRow][startColumn] = true;

    // 다음노드 예약 
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];
      for (int i = 0; i < 4; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (sky[nextRow][nextColumn] == 1) { // 알맞은 구름들
            if (!visited[nextRow][nextColumn]) { // 아직 방문하지 않은곳
              visited[nextRow][nextColumn] = true;
              queue.offer(new int[]{nextRow, nextColumn});
            } 
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    구름의개수 solution = new 구름의개수();
    int[][] sky = {
      {0, 1, 1, 1, 0},
      {1, 0, 1, 1, 0},
      {1, 0, 0, 0, 0},
      {0, 0, 0, 1, 0}
    };
    int result = solution.solution(sky);
    System.out.println(result);
  }
}
