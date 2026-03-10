package 자료구조.quiz;

import java.util.*;

public class Quiz3 {
  public int[] solution(int[] weights) {
    int n = weights.length;
    int[] answer = new int[n];
    Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      int weight = weights[i];
      while (!stack.isEmpty() && stack.peek()[1] < weight) {
        int[] prevInfo = stack.pop();
        int prevIndex = prevInfo[0];
        answer[prevIndex] = i - prevIndex;
      }
      stack.push(new int[] {i, weight});
    }
    return answer;
  }
  public static void main(String[] args) {
    Quiz3 quiz = new Quiz3();
    System.out.println(Arrays.toString(quiz.solution(new int[]{45, 42, 50, 48, 46, 49 , 51})));   // 2
  }
}
