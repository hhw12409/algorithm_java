package 그래프;

import java.util.*;

// 학교에서 운동회를 준비하며 학생들을 홍팀과 청팀으로 나누려고 합니다. 학생들 간의 친구 관계를 나타내는 2차원 배열 friends 가 주어집니다.
// friends[i]는 i번째 학생과 친구인 학생들의 번호를 나타냅니다.
// 친구 관계는 대칭적이며, 즉 학생 A가 학생 B의 친구라면, B도 A의 친구입니다.
// 일부 학생들은 친구가 없을 수도 있습니다.
// 당신의 목표는 학생들을 두 팀으로 나누는 것입니다.
// 단, 같은 팀에 속한 학생들끼리는 친구 관계가 없어야 합니다.
// 주어진 친구 관계를 바탕으로, 학생들을 두 팀으로 나눌 수 있다면 True, 그렇지 않다면 False를 반환하는 solution 함수를 작성하세요.
// Bipartite (이분 그래프)
public class 홍팀청팀 {
  public boolean solution(int[][] friends) {
    int n = friends.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int v = 0; v < n; v++) {
      if (color[v] == -1) {
        color[v] = 0;
        if (!dfs(v, friends, color)) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean dfs(int cur, int[][] friends, int[] color) {
    for (int next : friends[cur]) {
      if (color[next] == color[cur]) {
        return false;
      }
      if (color[next] == -1) {
        color[next] = 1 - color[cur];
        if (!dfs(next, friends, color)) {
          return false;
        }
      }
    }
    return true;
  }
}
