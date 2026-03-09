package 자료구조;

import java.util.*;

public class Quiz1 {

  public int solution(int[] prices, int target) {
    int answer = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[i] + prices[j] == target) {
          answer += 1;
        }
      }
    }
    return answer;
  }

  public int solution2(int[] prices, int target) {
    int answer = 0;
    Arrays.sort(prices);
    int left = 0;
    int right = prices.length - 1;
    while (left < right) {
      int sum = prices[left] + prices[right];
      if (sum == target) {
        answer += 1;
        left++;
        right--;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return answer;
  }

  public int solution3(int[] prices, int target) {
    int answer = 0;
    Set<Integer> priceSet = new HashSet<>();
    for (int price : prices) {
      int complement = target - price;
      if (priceSet.contains(complement)) {
        answer += 1;
      }
      priceSet.add(price);
    }
    return answer;
  }

  public static void main(String[] args) {
    Quiz1 quiz1 = new Quiz1();
    int[] prices = {1, 2, 3, 4, 5};
    int target = 5;
    System.out.println(quiz1.solution(prices, target)); // 2
    System.out.println(quiz1.solution2(prices, target)); // 2
    System.out.println(quiz1.solution3(prices, target)); // 2
  }
}
