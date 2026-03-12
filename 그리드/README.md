## 그리드(Grid)

그리드는 행(Row)과 열(Column)로 이루어진 **2차원 배열**을 의미한다.

```java
int[][] grid = {
  {1, 1, 1, 1},
  {0, 1, 0, 1},
  {0, 1, 0, 1},
  {1, 0, 1, 1}
}
```

## 암시적 그래프 (implicit graph, grid)

그래프의 노드와 간선이 명시적으로 저장되지 않고 필요에 따라 동적으로 생성되는 그래프를 의미한다.
예시문제) 만약 벽:1, 길:0 이라고 한다면 상하좌우 이동이 가능

```java
int[][] grid = {
  {1, 1, 0, 1, 1},
  {0, 0, 0, 1, 1},
  {1, 1, 0, 1, 1},
  {1, 0, 0, 0, 0},
  {1, 1, 1, 1, 1}
}
```

## 출제유형

1. 네트워크 개수

```java
int n = grid.length;
int m = grid[0].length;
int count = 0;
boolean[][] visited = new boolean[n][m];

for (int row = 0; row < n; row++) {
  for (int column = 0; column < m; column++) {
    if (grid[row][column] == 1) {
      if (!visited[row][column]) {
        dfs(row, column, grid, visited);
        count++;
      }
    }
  }
}
```

2. 요소의 개수
3. 두 요소간 연결 여부
