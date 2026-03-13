## 트리 (Tree)

트리는 단 하나의 **루트** 노드에서 시작하여, 모든 노드가 **부모-자식** 관계로 맺어지는 **계층형 자료구조**이다.
이러한 계층 구조로 인해 모든 노드가 하나로 이어지면서도 순환이 없는 **연결 비순환 그래프**가 된다.

트리는 n개의 노드가 있다면 n-1개의 간선이 있다.

> 순환이 없다란? 어떤 노드에서 출발해 다른 노드들을 거쳐 다시 자기 자신으로 돌아올 수 있는 경로가 없다.

## 트리의 구성 요소

1. 노드 (Node)
   트리를 구성하는 데이터와 다른 노드에 대한 연결 정보를 가진 기본 단위 요소
2. 간선 (Edge)
   노드와 노드 사이를 연결하는 선
3. 루트 (Root)
   트리 계층 구조의 가장 높은 곳에 있는 시작 노드 (부모가 없는 노드)
4. 리프 (Leaf)
   자식 노드가 하나도 없는, 트리의 가장 마지막에 위치한 노드
5. 차수 (Degree)
   특정 노드에 연결된 자식 노드의 개수. 트리 전체에서는 모든 노드 중에서 가장 자식이 많은 노드의 차수를 트리의 차수로 정의
6. 레벨 (Level)
   루트 노드로부터 특정 노드까지의 경로 길이(루트는 보통 레벨 0)
7. 높이 (Height)
   루트 노드에서 가장 멀리 있는 리프 노드까지의 거리 (간선의 수)
8. 조상 (Ancestor)
   특정 노드에서 루트 노드까지의 경로상에 있는 모든 부모 노드들
9. 자손 (Descendant)
   특정 노드로부터 뻗어나가는 하위 계층의 모든 노드들

## 트리의 종류

1. 일반 트리 (General Tree)
   각 노드가 가질 수 있는 자식 노드의 수에 아무런 제약이 없는 가장 기본적인 형태의 트리
2. 이진 트리 (Binary Tree)
   모든 노드가 최대 2개의 자식 노드(왼쪽 자식과 오른쪽 자식)를 가질 수 있는 트리
3. 완전 이진 트리 (Complete Binary Tree)
   마지막 레벨을 제외한 모든 레벨이 완전히 채워져 있으며, 마지막 레벨의 노드들은 왼쪽부터 순서대로 채워진 이진 트리
4. N-진 트리 (N-ary Tree)
   모든 노드가 최대 N개의 자식 노드를 가질 수 있도록 이진 트리를 일반화한 트리 구조

## Tree 구현

1. 인접리스트

```java
List<List<Integer>> tree = {
  0: {1, 2},
  1: {0},
  2: {0, 3, 4},
  3: {2},
  4: {2}
}
```

2. 간선리스트
   입력된 간선 리스트의 각 행 [a, b]는 a가 부모, b가 자식 노드임을 나타내는 단방향 관계입니다.
   이 트리의 루트 노드는 0번 노드입니다.

   > 문제를 풀 때 간선리스트를 인접리스트로 변환해서 푼다.

```java
int n = 5;
int[][] edges = {
  {0, 1},
  {0, 2},
  {2, 3},
  {2, 4}
}

// 2차원 배열 방법
List<List<Integer>> tree = new ArrayList<>(n); // n의 길이 만큼의 배열 생성
for (int i = 0; i < n; i++) {
  tree.add(new ArrayList<>()); // n개의 ArrayList에 자식노드를 저장할 빈 ArrayList를 만들어줌
}

for (int[] edge : edges) { // 자식노드들의 정보를 저장!
  tree.get(edge[0]).add(edge[1]);
}

// HashMap을 이용하는 방법
Map<Integer, List<Integer>> tree = new HashMap<>();
for (int i = 0; i < n; i++) {
  tree.put(i, new ArrayList<>()); // n개의 ArrayList에 자식노드를 저장할 빈 ArrayList를 만들어줌
}

for (int[] edge : edges) {
  tree.get(edge[0]).add(edge[1]); // 자식노드들의 정보를 저장!
  // tree.get(edge[1]).add(edge[0]); // 양방향 인접리스트 구현도 가능
}
```

3. 클래스 구현 (Binary)

```java
class Node {
  int value;
  Node left;
  Node right;
  public Node(int value) {
    this.value = value;
  }
}

Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);
```

4. 클래스 구현 (N-ary)

```java
class Node {
  int value;
  List<Node> children;
  public Node(int value) {
    this.value = value;
    this.children = new ArrayList<>();
  }
}

Node root = new Node(1);
root.children.add(new Node(2));
root.children.add(new Node(3));
root.children.add(new Node(4));
root.children.get(1).children.add(new Node(5));
```

## 트리 순회 (Traversal)

트리의 모든 노드를 중복 없이 한 번씩 방문하는 체계적인 방법을 말하며, 노드를 어떤 순서로 방문하느냐에 따라 여러 방식으로 나뉜다.

## BFS

루트 노드에서 시작하여, 같은 레벨(깊이)에 있는 노드들을 먼저 모두 방문 한 뒤 다음 레벨로 나아가는 탐색 기법
레벨 순서 순회(Level-order Traversal)라고도 한다.

## BFS 설계

1. 인접 리스트 (일방향)

> 트리이면서 일방향 인접리스트의 경우에는 graph와 다르게 visited가 필요없다. 애초에 tree는 사이클이 없다.(되돌아갈 일이 없다.) 즉, 방문하였던곳을 체크할 필요가 없다.

```java
tree = {
  0: {1, 3, 6},
  1: {},
  2: {},
  3: {2, 7},
  4: {},
  5: {4},
  6: {5},
  7: {}
}

void solution(List<List<Integer>> tree) {
  bfs(0, tree);
}

void bfs(int start, List<List<Integer>> tree) {
  // 루트노드 예약
  Queue<Integer> queue = new ArrayDeque<>();
  queue.offer(start);

  // 방문
  while (!queue.isEmpty()) {
    int cur = queue.poll();
    // 자식노드 예약
    for (int next: tree.get(cur)) {
      queue.offer(next);
    }
  }
}
```

2. 인접 리스트 (양방향)

```java
tree = {
  0: {1, 3, 6},
  1: {0},
  2: {3},
  3: {0, 2, 7},
  4: {5},
  5: {4, 6},
  6: {0, 5},
  7: {3}
}

void solution(List<List<Integer>> tree) {
  boolean[] visited = new boolean[tree.size()];
  bfs(0, tree, visited);
}

void bfs(int start, List<List<Integer>> tree, boolean[] visited) {
  // 루트노드 예약
  Queue<Integer> queue = new ArrayDeque<>();
  queue.offer(start);
  visited[start] = true;

  // 방문
  while (!queue.isEmpty()) {
    int cur = queue.poll();
    // 자식노드 예약
    for (int next: tree.get(cur)) {
      if (!visited[next]) {
        queue.offer(next);
        visited[next] = true;
      }
    }
  }
}
```

3. 클래스 구현 (Binary)

```java

class Node {
  int value;
  Node left;
  Node right;
  public Node(int value) {
    this.value = value;
  }
}
void solution(Node root) {
  bfs(root);
}

void bfs(Node root) {
  Queue<Node> queue = new ArrayDeque<>();
  queue.offer(root);

  while (!queue.isEmpty()) {
    Node cur = queue.poll();
    if (cur.left != null) queue.offer(cur.left);
    if (cur.right != null) queue.offer(cur.right);
  }
}
```

4. 클래스 구현 (N-ary)

```java
class Node {
  int value;
  List<Node> children;
  public Node(int value) {
    this.value = value;
    this.children = new ArrayList<>();
  }
}

void solution(Node root) {
  bfs(root);
}

void bfs(Node root) {
  Queue<Node> queue = new ArrayDeque<>();
  queue.offer(root);

  while (!queue.isEmpty()) {
    Node cur = queue.poll();
    for (Node child : cur.children) {
      queue.offer(child);
    }
  }
}
```

## DFS

루트 노드에서 시작하여, 한 경로를 따라 최대한 깊이 들어간 후, 더 이상 갈 곳이 없으면 이전 노드로 돌아와 다른 경로를 탐색하는 기법이다.
노드를 처리하는 순서에 따라 '전위, 중위, 후위 순회'가 있다.

## DFS 설계

1. 인접 리스트 (양방향)

```java
tree = {
  0: {1, 3, 6},
  1: {0},
  2: {3},
  3: {0, 2, 7},
  4: {5},
  5: {4, 6},
  6: {0, 5},
  7: {3}
}

void solution(int n, List<List<Integer>> tree) {
  boolean[] visited = new boolean[n];
  dfs(0, tree, visited);
}

void dfs(int cur, List<List<Integer>> tree, boolean[] visited) {
  // 방문
  visited[cur] = true;

  // 다음 노드 DFS 실행
  for (int child : tree.get(cur)) {
    if (!visited[child]) {
      dfs(child, tree, visited);
    }
  }
}
```

2. 인접 리스트 (일방향)

```java
tree = {
  0: {1, 3, 6},
  1: {},
  2: {},
  3: {2, 7},
  4: {},
  5: {4},
  6: {5},
  7: {}
}

void solution(int n, List<List<Integer>> tree) {
  dfs(0, tree);
}

void dfs(int cur, List<List<Integer>> tree) {
  // 다음 노드 DFS 실행
  for (int child : tree.get(cur)) {
    dfs(child, tree);
  }
}
```

3. 클래스 구현 (Binary)

```java
class Node {
  int value;
  Node left;
  Node right;
  public Node(int value) {
    this.value = value;
  }
}

void solution(Node root) {
  dfs(root);
}

void dfs(Node cur) {
  if (cur == null) return;
  dfs(cur.left);
  dfs(cur.right);
}
```

4. 클래스 구현 (N-ary)

```java
class Node {
  int value;
  List<Node> children;
  public Node(int value) {
    this.value = value;
    this.children = new ArrayList<>();
  }
}

void solution(Node root) {
  dfs(root);
}

void dfs(Node cur) {
  if (cur == null) return;
  for (Node child : cur.children)  {
    dfs(child);
  }
}
```

## DFS 종류

탐색하는 과정에서 '현재 노드(루트)'를 언제 방문(처리)하느냐에 따라서 '전위, 중위, 후위 순회'로 나뉜다.

1. 전위순회(pre-order)
   루트 노드를 가장 먼저 방문(처리)한 후, 자식 노드들을 정해진 순서(일반적으로 왼쪽부터)에 따라 순차적으로 탐색

```java
tree = {
  0: {1, 3, 6},
  1: {},
  2: {},
  3: {2, 7},
  4: {},
  5: {4},
  6: {5},
  7: {}
}
void dfs(int cur, List<List<Integer>> tree) {
  // 방문(처리)
  System.out.println(cur);

  // 자식노드들 DFS 실행
  for (int child : tree.get(cur)) {
    dfs(child, tree);
  }
}

// 방문(처리)순서 : 0 1 3 2 7 6 5 4
```

2. 중위순회(in-order)
   왼쪽 자식 노드들 -> 루트 노드 방문(처리) -> 오른쪽 자식 노드들을 탐색

   ```java
   void dfs(Node cur) {
    if (cur == null) return;

    // 왼쪽 DFS 실행
    dfs(cur.left);
    // 방문(처리)
    System.out.println(cur);
    // 오른쪽 DFS 실행
    dfs(cur.right);
   }

   // 방문(처리)순서 : 2 3 7 0 4 5 1 6
   ```

3. 후위순회(post-order)
   모든 자식 노드들을 정해진 순서(일반적으로 왼쪽부터)에 따라 먼저 모두 탐색한 후, 루트 노드를 가장 마지막에 방문(처리)

```java
tree = {
  0: {1, 3, 6},
  1: {},
  2: {},
  3: {2, 7},
  4: {},
  5: {4},
  6: {5},
  7: {}
}

void dfs(int cur, List<List<Integer>> tree) {
  // 자식노드들 DFS 실행
  for (int child : tree.get(cur)) {
    dfs(child, tree);
  }
  // 방문(처리)
  System.out.println(cur);
}

// 방문(처리)순서 : 1 2 7 3 4 5 6 0
```
