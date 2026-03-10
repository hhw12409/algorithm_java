package 완전탐색과순열조합;

import java.util.*;

public class Permutation {
  public List<List<Integer>> solution(int[] nums, int m) {
    return dfs(nums, m, new ArrayList<>(), new boolean[nums.length]);
  }

  public List<List<Integer>> dfs(int[] nums, int m, List<Integer> curr, boolean[] visited) {
    List<List<Integer>> answer = new ArrayList<>();
    if (curr.size() == m) {
      answer.add(new ArrayList<>(curr));
      return answer;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        curr.add(nums[i]);
        visited[i] = true;
        answer.addAll(dfs(nums, m , curr, visited));
        visited[i] = false;
        curr.remove(curr.size() - 1);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Permutation permutation = new Permutation();
    System.out.println(permutation.solution(new int[]{1, 2, 3, 4}, 2));
  }
}
