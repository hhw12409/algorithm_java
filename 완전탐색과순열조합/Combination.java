package 완전탐색과순열조합;

import java.util.*;

public class Combination {
  List<List<Integer>> combination(int[] nums, int m) {
    return dfs(nums, m, 0, new ArrayList<>());
  }

  List<List<Integer>> dfs(int[] nums, int m, int start, List<Integer> curr) {
    List<List<Integer>> answer = new ArrayList<>();
    if (curr.size() == m) {
      answer.add(new ArrayList<>(curr));
      return answer;
    }

    for (int i = start; i < nums.length; i++) {
      curr.add(nums[i]);
      answer.addAll(dfs(nums, m, i + 1, curr));
      curr.remove(curr.size() - 1);
    }
    return answer;
  }
  public static void main(String[] args) {
    Combination combination = new Combination();
    System.out.println(combination.combination(new int[]{1, 2, 3, 4}, 2));
  
  }
}
