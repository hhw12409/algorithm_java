package 자료구조.quiz;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz2 {
  // 소괄호쌍
  public int solution(String words) {
    int answer = 0;
    Deque<Character> stack = new ArrayDeque<>();
    
    for (char c : words.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return -1;
        }
        stack.pop();
        answer++;
      }
    }

    return stack.isEmpty() ? answer : -1;
  }

  // 괄호쌍
  public int solution2(String words) {
    int answer = 0;
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : words.toCharArray()) {
      if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '(') {
        stack.push(')');
      }
      else {
        if (stack.isEmpty() || stack.peek() != c) {
          return -1;
        } else if (stack.peek() == c) {
          stack.pop();
          answer++;
        }
      }
    }
    return stack.isEmpty() ? answer : -1;
  }
  public static void main(String[] args) {
    
  }
}
