package DP;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
  // top-down
  public int solution(int[] cost) {
    int n = cost.length;
    // memo를 만든다.
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return dp(memo, cost, n);
  }

  public int dp(int[] memo, int[] cost, int n) {
    // 0번째 계단 혹은 1번째 계단일 경우, 0을 반환한다. (base case)
    if (n == 0 || n == 1) {
      return 0;
    }
    // 현재 계단 (n)까지의 도달에 필요한 비용이 memo에 없다면, (-1);
    else if (memo[n] == -1) {
      // 점화식에 따라 재귀함수를 호출하여 n번째 계단에 대한 최소 비용을 구한다.
      memo[n] = Math.min(dp(memo, cost, n - 1) + cost[n - 1], dp(memo, cost, n - 2) + cost[n - 2]);
    }
    // 현재 계단(n)까지의 도달에 필요한 최소 비용을 반환한다.
    return memo[n];
  }

  // bottom-up
  public int solution2(int[] cost) {
    int n = cost.length;
    
    // 목표 계단 수 +1(cost의 길이 + 1) 크기의 dp 테이블을 만든다.
    int[] dp = new int[n + 1];
    // 0번째, 1번째 계단에 0을 저장한다.
    dp[0] = 0;
    dp[1] = 0;
    // 2번째 계단부터 n번째 계단까지 올라간다.
    for (int i = 2; i < n + 1; i++) {
      // 점화식에 따라 각 계단에 오르기 위해 필요한 최소 비용을 구한다.
      dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }
    // n번째 계단에 도달하기 위해 필요한 최소 비용을 반환한다.
    return dp[n];
  }
}
