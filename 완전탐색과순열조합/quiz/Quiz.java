package 완전탐색과순열조합.quiz;

// 세계 일주를 위해 balance만큼의 초기 자금을 가지고 있습니다.
// countries 배열에는 각 나라의 여행 정보가 2차원 배열 형태로 담겨 있습니다.
// 각 나라는 [여행 경비, 입국 필요 잔고] 형식으로 주어집니다. 어떤 나라를 방문하기 위해서는 두가지 규칙을 따라야 합니다.
// - 입국 조건 : 그 나라에 입국하려면, 현재 통장 잔고가 그 나라가 요구하는 '입국 필요 잔고'보다 같거나 많아야 합니다.
// - 경비 소모 : 여행을 무사히 마치면, 현재 잔고에서 '여행 경비'가 차감됩니다.
// 각 나라는 한 번만 방문할 수 있으며, 방문 순서를 어떻게 정하느냐에 따라 방문할 수 있는 총 나라 수가 달라질 수 있습니다.
// 현재 잔고 balance와 나라별 정보 countries를 가지고 있을 때, 방문할 수 있는 최대 국가 수를 반환하는 solution함수를 생성

// input : balance=600, countries=[[70, 350], [100, 550], [350, 400]] // output=3
// input : balance=500, countries=[[250, 250], [300, 400], [120, 450], [70, 150]] // output=3

// 완전탐색(재귀) - O(n^n)
// 순열 - O(n!)
public class Quiz {
  int maxCountries;

  public int solution(int balance, int[][] countries) {
    int n = countries.length;
    boolean[] visited = new boolean[n];
    maxCountries = 0;
    dfs(balance, 0, countries, visited);
    return maxCountries;
  }

  public void dfs(int balance, int count, int[][] countries, boolean[] visited) {
    maxCountries = Math.max(maxCountries, count);
    for (int i = 0; i < countries.length; i++) {
      if (!visited[i] && balance >= countries[i][1]) {
        visited[i] = true;
        dfs(balance - countries[i][0], count + 1, countries, visited);
        visited[i] = false;
      }
    }
  }
  public static void main(String[] args) {
    
  }  
}
