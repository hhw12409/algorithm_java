package basic;

public class 완전탐색 {
  // 리스트에서 주어진 target값과 일치하는 요소의 인덱스를 찾으세요.
  int solution(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1; // target이 리스트에 없는 경우
  }

  // 리스트에서 두 요소의 합이 target이 되는 인덱스를 반환 하세요. (중복 x) O(N^2)
  int[] solution2(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j}; // 두 인덱스를 배열로 반환
        }
      }
    }
    return new int[]{-1, -1}; // target이 리스트에 없는 경우
  }

  //  주어진 격자(grid)에서 가장 큰 값을 반환 하세요.
  int solution3(int[][] grid) {
    int answer = 0; // 가장 작은 값으로 초기화
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] > answer) {
          answer = grid[i][j]; // 더 큰 값이 있으면 업데이트
        }
      }
    }
    return answer;
  }
}
