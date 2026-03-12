package 그리드;

public class 암시적그래프DFS {
  int n;
  int m;
  // 4개의 방향 일 경우
  int[] dr = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위쪽
  int[] dc = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위쪽

  void solution(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    dfs(0, 0, grid, visited);
  }
  void dfs(int row, int column, int[][] grid, boolean[][] visited) {
    // 방문
    visited[row][column] = true;
    // 방문안한 다음 노드 찾기
    for (int i = 0; i < 4; i++) {
      int nextRow = row + dr[i];
      int nextColumn = column = dc[i];
      if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
        if (grid[nextRow][nextColumn] == 1) {
          if (!visited[nextRow][nextColumn]) {
            dfs(nextRow, nextColumn, grid, visited);
          }
        }
      }
    }
    // 다음 노드 DFS 실행
  }
}
