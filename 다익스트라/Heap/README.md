## Heap

들어온 순서에 상관없이, 일정한 기준(우선순위)에 따라 요소들이 나오도록 할 수 있는데, 이를 일반적인 queue와 구분 지어, **priority queue**라고 한다.
그런데 원소를 추가할 때마다, 오름차순 혹은 내림차순으로 알아서 정렬해 주는 자료구조인 heap를 통해 **priority queue**를 구현할 수 있다.

Java에서 priority queue 사용
Java에는 **PriorityQueue**라는 우선순위 큐가 있다. **PriorityQueue**는 다음과 같이 사용한다.

```java
Queue<Integer> pq = new PriorityQueue<Integer>();

// enque
pq.add(3);
pq.add(1);
pq.add(8);

while (!pq.isEmpty()) {
  Integer value = pq.remove();
  System.out.println(value);
}
```

> **ArrayDeque**클래스를 큐로 사용할 때와 같은 방식으로 사용이 가능하다. 왜냐하면 **ArrayDeque**클래스 처럼 **PriorityQueue**클래스도 **Queue** 인터페이스를 구현하기 때문이다. 다른 점은 **ArrayDeque**은 들어온 순서대로 dequeue된 반면 **PriorityQueue**는 우선순위 큐이기 때문에 우선순위가 높은 것부터 dequeue된다.

## Collection으로 heap 만들기

List나 Set같은 컬렉션 인스턴스를 PriorityQueue생성자의 인자로 넘겨줌으로써 컬렉션을 힙으로 바꿀 수 있다.

```java
List<Integer> list = List.of(1, 4, 2, 3, 5, 6);
Queue<Integer> pq = new PriorityQueue<>(list);
```

## Max heap 만들기

PriorityQueue 클래스는 기본적으로 min heap이다. 만약 PriorityQueue를 max heap으로 만들고 싶다면 인스턴스 생성 시에 Collections.reverseOrder()를 추가해주면 된다.

```java
Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
```

## 커스텀 클래스 만들기

우선순위 큐에 단일 정수, 문자열이 아닌 복합 데이터(ex:좌표)를 저장해야 한다면 커스텀 클래스를 구현하여 사용해야 합니다.
우선순위 큐에 사용할 커스텀 클래스는 **Comparable<T>** 인터페이스를 구현해야 합니다.
**Comparable<T>** 인터페이스는 두 객체간 비교를 해주는 **compareTo()** 메소드를 가지고 있습니다.

예시 코드

```java
class Person implements Comparable<Person> {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Person o) {
    return this.age - o.age;
  }
}
```

compareTo() 메소드는 자기 자신과 파라미터로 받은 인스턴스(위의 경우에는 **Person o**)를 비교하여 자신이 우선순위가 높다면 음수, 같다면 0, 낮아면 양수를 반환한다.
따라서 위 경우 나이가 적은 인스턴스가 더 높은 우선순위를 가지게 된다.

## heap의 정의

heap은 min heap과 max heap으로 나누어져 있다. 각각의 정의는 아래와 같다.

- min heap: 자식 노드의 값이 부모 노드의 값보다 큰 트리 형태의 자료구조 (부모 노드 값 < 자식 노드 값)
- max heap: 자식 노드의 값이 부모 노드의 값보다 작은 트리 형태의 자료 구조 (부모 노드 값 > 자식 노드 값)

heap은 정렬이 완료된 자료구조가 아니다.
min heap으로 만들었을 때, a[0]은 항상 제일 작은 값이지만, 그 이후로부터는 알 수 없다.
즉, a[1]이 두번째로 작은 것을 보장할 수 없다. 왜냐면, heap에서 왼쪽 자식노드와 오른쪽 자식 노드의 크기를 비교하지 않기 때문이다.
그래서 위의 예시에서도 1,3,2,... 순으로 정렬된 것을 확인 할 수 있다.
max heap의 경우도 마찬가지로 a[0]은 항상 가장 큰 값을 가지지만, a[1]이 2번째로 큰 값이라고 확신할 수 없다.

## 코딩테스트 활용

1. 다익스트라 알고리즘에 사용

- 다익스트라 알고리즘을 구현 할 때, 우선순위큐를 사용해서 구현한다.

2. 반복적으로 최댓값 혹은 최솟값을 찾아야하는 경우
   - 우선순위 큐는 가장 높은 우선순위의 데이터부터 추출하는 자료구조이다. 반목 마다 최적의 값, 즉 최댓값 혹은 최솟값을 찾아야 하는 상황에서 억지로 모든 데이터에 대해서 정렬하는 것은 매우 소모적인 행위이다. 이러한 경우, heap를 통해 우선순위 큐를 구현해서 최댓값 혹은 최솟값만을 얻을 수 있으면 빠르게 문제를 해결할 수 있다.
     대표적인 문제로 백준의 2072번 (N번째 큰 수), 1715번 (카드 정렬하기) 등을 꼽을 수가 있다.
