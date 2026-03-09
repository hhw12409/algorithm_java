package 자료구조;

import java.util.ArrayDeque;
import java.util.Deque;

// 가장 나중에 입력된 데이터가 가장 먼저 출력되는 후입선출(LIFO, Last In First Out) 원칙을 따르는 자료구조이다.
// Push로 가장 최근에 추가된 데이터가 Pop을 통해 가장 먼저 출력된다.
public class StackExample {
  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    int top = stack.peek();
    System.out.println(top); // 50
    while (!stack.isEmpty()) {
      int item = stack.pop();
      System.out.println(item);
    }
  }
}
