package 완전탐색과순열조합;

import java.util.*;

// 완전탐색 (재귀)
public class DFS {
  public boolean solution(int[] nums, int target) {
    return dfs(nums, target, 0, new ArrayList<>());
  }

  public boolean dfs(int[] nums, int target, int start, List<Integer> selected) {
    if (selected.size() == 3) {
      int sum = 0;
      for (int n : selected) {
        sum += n;
      }
      return sum == target;
    }
    for (int i = start; i < nums.length; i++) {
      selected.add(nums[i]);
      if (dfs(nums, target, i + 1, selected)) {
        return true;
      }
      selected.remove(selected.size() - 1);
    }
    return false;
  }

  public boolean solution(int[] nums, int target, int m) {
    return dfs(nums, target, m, 0, 0, 0);
  }

  public boolean dfs(int[] nums, int target, int m, int start, int sum, int depth) {
    if (depth == m) {
      return sum == target;
    }
    for (int i = start; i < nums.length; i++) {
      sum += nums[i];
      if (dfs(nums, target, m, i + 1, sum, depth + 1)) {
        return true;
      }
      sum -= nums[i];
    }
    return false;
  }

  public static void main(String[] args) {
    DFS dfs = new DFS();
    System.out.println(dfs.solution(new int[]{4, 9, 7, 5, 1}, 17));
  }
}
