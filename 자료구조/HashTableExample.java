package 자료구조;

import java.util.HashMap;
import java.util.Map;

// 해시테이블(Hash Table)은 Key와 Value를 한 쌍으로 저장하는 자료구조입니다.
// 해시 함수(Hash Function)가 Key를 특정 숫자(인덱스)로 변환해주면, 데이터를 해당 위치의 배열 공간(버킷)에 바로 저장합니다.
public class HashTableExample {
  public static void main(String[] args) {
    Map<String, String> userMap = new HashMap<>();

    userMap.put("user1", "Alice");
    userMap.put("user2", "Bob");
    userMap.put("user3", "Charlie");
    userMap.put("user1", "Alice2");

    String adminName = userMap.get("user1");
    System.out.println(adminName); // Alice2

    userMap.remove("user2");

    boolean hasUser3 = userMap.containsKey("user3");
    System.out.println(hasUser3); // true
    System.out.println(userMap.containsKey("Helloworld")); // false

    for (Map.Entry<String, String> entry : userMap.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(key + ": " + value);
    }

    for (String key : userMap.keySet()) {
      System.out.println(key);
    }

    // java 8 이상에서는 forEach 메서드와 람다식을 사용하여 간결하게 반복할 수 있다.
    userMap.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });
  }
}
