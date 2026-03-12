package 그리드;

import java.util.*;

public class 암시적그래프BFS {
  void solution(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    bfs(0, 0, grid, visited);
  }

  void bfs(int startRow, int startColumn, int[][] grid, boolean[][] visited) {
    int n = grid.length;
    int m = grid[0].length;
    // 4개의 방향 일 경우
    int[] dr = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위쪽
    int[] dc = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위쪽

    // 8개의 방향 일 경우
    // int[] dr = {0, 1, 0, -1, 1, -1, -1, 1}; // 오른쪽, 아래, 왼쪽, 위쪽, 오른쪽아래, 왼쪽위, 오른쪽위, 왼쪽아래
    // int[] dc = {1, 0, -1, 0, 1, -1, 1, -1}; // 오른쪽, 아래, 왼쪽, 위쪽, 오른쪽아래, 왼쪽위, 오른쪽위, 왼쪽아래
    
    // 시작노드 예약
    Queue<int[]> queue = new ArrayDeque<>(); 
    queue.offer(new int[]{startRow, startColumn});
    visited[startRow][startColumn] = true;

    while (!queue.isEmpty()) {
      // 다음노드 예약
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];
      for (int i = 0; i < 4; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (grid[nextRow][nextColumn] == 1) {
            if (!visited[nextRow][nextColumn]) {
              queue.offer(new int[]{nextRow, nextColumn});
              visited[nextRow][nextColumn] = true;
            }
          }
        }
      }
    }
  }

  // 최단거리 찾기
  int bfs(int[][] grid) {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int n = grid.length;
    int m = grid[0].length;
    int[][] dist = new int[n][m];

    // 시작노드 예약
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{0, 0});
    dist[0][0] = 1;

    // 다음 노드 방문 예약
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];
      // base case
      if (row == n - 1 && column == m - 1) return dist[row][column];
      
      for (int i = 0; i < 4; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (grid[nextRow][nextColumn] == 1) { // 알맞은 길
            if (dist[nextRow][nextColumn] == 0) { // 아직 방문 하지 않은곳
              dist[nextRow][nextColumn] = dist[row][column] + 1;
              queue.offer(new int[]{nextRow, nextColumn});
            } 
          }
        }
      }
    }
    return -1;
  }
}
