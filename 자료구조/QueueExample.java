package 자료구조;

import java.util.ArrayDeque;
import java.util.Queue;

// 가장 먼저 입력된 데이터가 가장 먼저 출력되는 선입선출(FIFO, First In First Out) 방식의 자료구조
// Enqueue(삽입), Dequeue(삭제), Peek(조회) 연산이 있다.
// Enqueue로 먼저 추가된 데이터가 Dequeue를 통해 가정 먼저 출력된다.
public class QueueExample {
  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(10);
    queue.offer(20);
    queue.offer(30);
    queue.offer(40);

    int nextItem = queue.peek();
    System.out.println(nextItem); // 10
    while (!queue.isEmpty()) {
      int item = queue.poll();
      System.err.println(item);
    }
    System.out.println(queue.poll()); // null
  }
}
