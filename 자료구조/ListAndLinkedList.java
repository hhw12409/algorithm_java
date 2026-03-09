package 자료구조;

import java.util.LinkedList;
import java.util.ListIterator;

// 연결  리스트(Linked List)는 여러 노드(Node) 객체들을 연결하여 데이터를 저장하는 자료구조이다.
// 각각의 노드 객체는 실제 저장할 데이터와, 다음 노드 객체를 가리키는 참조(주소값)을 가지고 있다.
// 이 노드 객체들은 메모리상에 연속으로 붙어있지 않고 흩어져 있을 수 있지만, 이 참조값을 따라가면서 순서대로 데이터 접근 할 수 있다.

// 단일 연결 리스트 (Singly Linked List)
// 각 노드는 오직 '다음(next)' 노드의 참조(주소값)만을 가지고 있다.

// 이중 연결 리스트 (Doubly Linked List)
// 각 노드가 '다음(next)' 노드뿐만 아니라 '이전(previous)' 노드의 참조도 저장.
// 현재 노드에서 다음 노드로, 또는 이전 노드로 양방향 탐색이 모두 가능함.
// 자바의 java.util.LinkedList 클래스는 이중 연결 리스트로 구현되어 있다.
public class ListAndLinkedList {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("B");
    list.add("C");
    list.addFirst("A"); // O(1)
    list.addLast("D"); // O(1)
    list.add("C");
    list.add("E");
    list.add("F");

    // 조회
    String s1 = list.get(3); // O(n)
    String s2 = list.getFirst(); // O(1)
    String s3 = list.getLast(); // O(1)

    // 삭제
    list.removeFirst(); // O(1)
    list.removeLast(); // O(1)
    list.remove("C"); // O(n) - 첫 번째 "C" 요소를 찾아서 삭제

    int size = list.size();
    boolean hasC = list.contains("C");

    LinkedList<String> list2 = new LinkedList<>();
    list2.add("A");
    list2.add("B");
    list2.add("C");
    list2.add("D");
    list2.add("E");
    list2.add("F");

    ListIterator<String> cursor = list2.listIterator(4); // 커서를 4번 인덱스 위치로 이동
    if (cursor.hasPrevious()) {
      cursor.previous(); // 커서를 3번 인덱스 위치로 이동
      cursor.remove(); // 커서가 가리키는 요소 "D" 삭제
    }

    if (cursor.hasPrevious()) {
      cursor.previous(); // 커서를 2번 인덱스 위치로 이동
      cursor.remove(); // 커서가 가리키는 요소 "C" 삭제
    }

    if (cursor.hasNext()) {
      cursor.next(); // 커서를 3번 인덱스 위치로 이동
      cursor.remove(); // 커서가 가리키는 요소 "E" 삭제
    } 
  }
}
