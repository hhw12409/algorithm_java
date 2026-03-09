package 자료구조;

import java.util.HashSet;

// 해시셋(Hash Set)은 중복된 요소를 허용하지 않는 집합(Set) 자료구조입니다.
// 내부적으로 해시 테이블을 사용하여 요소를 저장하며 빠른 검색과 삽입이 가능합니다. 요소의 순서는 보장되지 않습니다. 
public class HashSetExample {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<String>();
    set.add("A");
    set.add("B");
    set.add("C");
    set.add("A"); // 중복된 요소는 추가되지 않음

    System.out.println(set.contains("B")); // true
    System.out.println(set.contains("D")); // false

    set.remove("C");

    for (String item : set) {
      System.out.println(item);
    }

    int size = set.size();
    System.out.println("Set size: " + size);
  }
}
