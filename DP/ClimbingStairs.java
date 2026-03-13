package DP;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs { 
  // Top-down
  public int solution(int n) {
    // 목표 계단 수(n) 크기의 memo를 만들고 -1로 초기화를 한다.
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return dp(memo, n);
  }

  public int dp(int[] memo, int n) {
    // 현재 계단 순서(n)가 0번째 혹은 1번째일 경우, 1을 반환한다. (base case)
    if (n == 0 || n == 1) {
      return 1;
    }
    // 현재 계단(n)에 도달하는 가짓수가 지정되어있지 않다면, (-1)
    else if (memo[n] == -1) {
      // n-1번째, n-2번째 계단에 대하여 재귀함수를 호출한다. (recurrence relation)
      memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
    }
    // 현재 계단(n)에 도달하는 총 가짓수를 반환한다.
    return memo[n];
  }
  // Bottom-up
  public int solution2(int n) {
    // 목표 계단 수 (n) 크기의 dp 테이블을 만든다.
    int[] dp = new int[n + 1];
    // 0번째, 1번째 계단을 1로 저장한다.
    dp[0] = 1;
    dp[1] = 1;
    // 2번째 계단부터 n번째 계단까지 올라간다.
    for (int i = 2; i < n + 1; i++) {
      // 점화식에 따라 각 계단에 도달할 수 있는 총 가짓수를 구한다.
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    // 현재 계단(n)에 도달하는 총 가짓수를 반환한다.
    return dp[n];
  }
}
