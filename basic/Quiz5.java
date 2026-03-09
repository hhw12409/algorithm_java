package basic;

public class Quiz5 {
  void solution(int n) { // O(n log n)
    for (int i = 0; i < n; i++) {
      int j = 1;
      while (j < n) {
        j *= 2;
      }
    }
  }  
}
