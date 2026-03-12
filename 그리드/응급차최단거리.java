package 그리드;

import java.util.*;

// 한 도시에 큰 사고가 발생하여 응급차가 부상자를 구조하기 위해 출동해야 합니다. 
// 도시는 m x n크기의 이진 행렬로 표현되며, 
// 0은 차량이 통행 가능한 도로를, 
// 1은 통행이 불가능한 구역을 나타냅니다. 
// 응급차는 도시의 왼쪽 위(0, 0)에서 출발하여 오른쪽 아래(m-1, n-1)에 위치한 부상자를 구조해야 합니다.
// 응급차는 이동 가능한 도로(0)만을 따라 상하좌우 또는 대각선으로 인접한 칸으로 이동할 수 있으며, 
// 경로의 길이는 방문한 칸의 개수로 정의됩니다. 
// 만약 응급차가 부상자에게 도달할 수 없는 경우, -1을 반환해야 합니다. 
// 도로망을 분석하여 응급차가 도착할 수 있는 가장 짧은 경로의 길이를 반환하는 solution 함수를 작성해주세요.
public class 응급차최단거리 {
  int n;
  int m;
  int[] dr = {0, 1, 0, -1, 1, -1, -1, 1};
  int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};

  int solution(int[][] city) {
    n = city.length;
    m = city[0].length;
    int[][] dist = new int[n][m];
    return bfs(0, 0, city, dist);
  }

  int bfs(int startRow, int startColumn, int[][] city, int[][] dist) {
    // 시작노드 예약
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{startRow, startColumn});
    dist[startRow][startColumn] = 1;

    // 다음 노드 방문 예약
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];

      // base case
      if (row == n - 1 && column == m - 1) return dist[row][column];

      for (int i = 0; i < 8; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (city[nextRow][nextColumn] == 0) { // 차량이 통행 가능한곳
            if (dist[nextRow][nextColumn] == 0) { // 아직 방문 안한곳
              dist[nextRow][nextColumn] = dist[row][column] + 1;
              queue.offer(new int[]{nextRow, nextColumn});
            } 
          } 
        }
      }
    }
    return -1;
  }

  public int solution2(int[][] city) {
    int n = city.length;
    int m = city[0].length;
    int shortestDist = -1;
    int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
    boolean[][] visited = new boolean[n][m];

    // 시작점이나 끝점이 1이면 바로 종료
    if (city[0][0] == 1 || city[n -1][m - 1] == 1) {
      return shortestDist;
    }

    // 시작점 예약
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{0, 0, 1});
    visited[0][0] = true;
    
    // while queue
    while (!queue.isEmpty()) {
      // 현재 노드 방문
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];
      int dist = cur[2];

      // 목적지 도착시 종료
      if (row == n - 1 && column == m - 1) {
        shortestDist = dist;
        break;
      }

      // 다음 노드 예약  
      for (int i = 0; i < 8; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (city[nextRow][nextColumn] == 0) { // 이용 가능한 도로 임
            if (!visited[nextRow][nextColumn]) { // 방문 안한 곳임
              queue.offer(new int[]{nextRow, nextColumn, dist + 1});
              visited[nextRow][nextColumn] = true;
            }
          }
        }
      }
    }
    return shortestDist;
  }

  public int solution3(int[][] city) {
    int n = city.length;
    int m = city[0].length;
    int shortestDist = -1;
    int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
    int[][] visited = new int[n][m];
    for (int[] row : visited) {
      Arrays.fill(row, 0);
    }

    // 시작점이나 끝점이 1이면 바로 종료
    if (city[0][0] == 1 || city[n -1][m - 1] == 1) {
      return shortestDist;
    }

    // 시작점 예약
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{0, 0});
    visited[0][0] = 1;
    
    // while queue
    while (!queue.isEmpty()) {
      // 현재 노드 방문
      int[] cur = queue.poll();
      int row = cur[0];
      int column = cur[1];

      // 목적지 도착시 종료
      if (row == n - 1 && column == m - 1) {
        return visited[row][column];
      }

      // 다음 노드 예약  
      for (int i = 0; i < 8; i++) {
        int nextRow = row + dr[i];
        int nextColumn = column + dc[i];
        if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
          if (city[nextRow][nextColumn] == 0) { // 이용 가능한 도로 임
            if (visited[nextRow][nextColumn] == 0) { // 방문 안한 곳임
              queue.offer(new int[]{nextRow, nextColumn});
              visited[nextRow][nextColumn] = visited[row][column] + 1;
            }
          }
        }
      }
    }
    return shortestDist;
  }

  public static void main(String[] args) {
    응급차최단거리 solution = new 응급차최단거리();
    int[][] city = {
      {0, 0, 1, 0},
      {1, 0, 1, 0},
      {1, 0, 0, 0}
    };
    int result = solution.solution(city);
    System.out.println(result);
  }
}
