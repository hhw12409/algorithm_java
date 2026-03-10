package 완전탐색과순열조합;

import java.util.*;

// 부분집합
public class Combination2 {
  public List<List<Integer>> combination(int[] nums, int m) {
    return dfs(nums, m, 0, new ArrayList<>());
  }

  // 모든 길이의 조합을 생성
  public List<List<Integer>> dfs(int[] nums, int m, int start, List<Integer> curr) {
    List<List<Integer>> answer = new ArrayList<>();
    answer.add(new ArrayList<>(curr));
    for (int i = start; i < nums.length; i++) {
      curr.add(nums[i]);
      answer.addAll(dfs(nums, m, i + 1, curr));
      curr.remove(curr.size() - 1);
    }
    return answer;
  }

  // 각 원소 포함/미포함
  public List<List<Integer>> subset(int[] nums) {
    return dfs(nums, new ArrayList<>(), 0);
  }

  public List<List<Integer>> dfs(int[] nums, List<Integer> curr, int idx) {
    List<List<Integer>> answer = new ArrayList<>();
    if (idx == nums.length) {
      answer.add(new ArrayList<>(curr));
      return answer;
    }

    answer.addAll(dfs(nums, curr, idx + 1));

    curr.add(nums[idx]);
    answer.addAll((dfs(nums, curr, idx + 1)));
    curr.remove(curr.size() - 1);

    return answer;
  }
  public static void main(String[] args) {
    Combination2 combination2 = new Combination2();
    System.out.println(combination2.combination(new int[]{1, 2, 3, 4}, 4));
    System.out.println(combination2.subset(new int[]{1, 2, 3, 4}));
  }
}
