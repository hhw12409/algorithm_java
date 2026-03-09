package basic;

// 얼핏 보면 이중 루프라서 O(n²)처럼 보이지만, j가 리셋되지 않는다는 점이 핵심입니다.
// 시간복잡도: O(n)
public class Quiz4 {
  void solution(int n) {
    int j = 0;
    for (int i = 0; i < n; i++) {
      while (j < n) {
        j++;
      }
    }
  }
}
