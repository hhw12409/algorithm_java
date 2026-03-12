package 그래프;

import java.util.*;

// 편의점에서 일을하고 있는 정희는 계산을 마치고 잔돈을 거슬러 주어야 합니다.
// 잔돈을 거슬러 주기 위해 최소 개수의 동전과 지폐를 사용해야 합니다. 이때, 사용된 동전과 지폐의 최소 개수를 반환하는 solution 함수를 작성하세요.
// 잔돈의 총액이 amount로 주어지며, 항상 단위에 맞는 금액만 입력됩니다. 만약 거슬러 줄 수 없는 경우에는 -1을 반환하세요.
public class 잔돈교환 {
  public int solution(int[] coins, int amount) {
    Queue<int[]> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(new int[]{amount, 0});
    visited.add(amount);

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curAmount = cur[0];
      int count = cur[1];
      if (curAmount == 0) {
        return count;
      }
      for (int coin : coins) {
        int nextAmount = curAmount - coin;
        if (nextAmount < 0) continue;
        if (!visited.contains(nextAmount)) {
          queue.add(new int[]{nextAmount, count + 1});
          visited.add(nextAmount);
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    
  }
}
