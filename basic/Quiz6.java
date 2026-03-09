package basic;

public class Quiz6 {
  void solution(int n) { // O(n)
    int j = 1;
    for (int i = 0; i < n; i++) {
      while (j < n) {
        j *= 2;
      }
    }
  }
}
