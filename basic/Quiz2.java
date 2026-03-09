package basic;

public class Quiz2 {
  void solution(int[] arr) {
    for (int i = 0; i < 10; i++) {
      for (int num : arr) {
        System.out.println(num); // O(m)
      }
    }
  }
}
