package basic;

public class Quiz1 {
  int solution(int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        count++;
      }
    }
    return count;
  }
  public static void main(String[] args) {
    Quiz1 quiz = new Quiz1(); // O(n^2)
    int n = 5;
    int result = quiz.solution(n);
    System.out.println(result);
  }
}