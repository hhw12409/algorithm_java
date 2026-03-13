package 트리;

import java.util.*;

// 당신은 시스템 보안 엔지니어입니다.
// 파일 시스템은 트리 구조로 구성되어 있으며, 각 폴더는 하나의 부모 폴더를 갖고, 최상위 폴더는 “root” 입니다.
// 어느 날 두 개의 하위 폴더에 바이러스가 감염되었다는 사실을 알게 되었습니다.
// 당신의 임무는 이 바이러스를 제거하는 것인데, 
// 감염된 두 폴더를 모두 포함하는 하나의 상위 폴더를 삭제함으로써 이를 해결할 수 있습니다.
// 시스템을 최대한 안전하게 유지하기 위해, 삭제 범위를 최소화하고자 합니다.
// 파일 시스템의 폴더 구조(folders)와 두 감염 폴더의 이름(p, q)이 주어질 때, 
// 이들을 동시에 제거할 수 있는 최소 범위의 상위 폴더 이름을 반환하는 solution 함수를 작성하세요.
// 단, 두 폴더는 서로 다른 경로에 존재하는 별개의 폴더이며, 동일한 폴더를 두 번 지목하는 경우는 없습니다.
public class 감염된폴더 {
  // 트리 구현(인접리스트)
  public String solution(String[][] folders, String p, String q) {
    Map<String, List<String>> tree = new HashMap<>();
    for (String[] pair : folders) {
      String parent = pair[0];
      String child = pair[1];
      tree.putIfAbsent(parent, new ArrayList<>());
      tree.get(parent).add(child);
    }
    return dfs(tree, "root", p, q);
    // 깊이 우선 탐색 (후위 순회)
  }
  String dfs(Map<String, List<String>> tree, String node, String p, String q) {
    // base case
    // [기저사례] 현재노드가 타켓(p 또는 q)이면 반환
    if (node.equals(p) || node.equals(q)) {
      return node;
    }

    // [재귀탐색] 자식 노드들 탐색 (찾아서 found라는 변수에 담아줌)
    List<String> found = new ArrayList<>();
    List<String> children = tree.getOrDefault(node, new ArrayList<>());
    for (String child : children) {
      String res = dfs(tree, child, p, q);
      if (res != null) {
        found.add(res);
      }
    }
    // [결과처리] 1. 두 자식에서 타켓 발견 : 현재 노드가 공통 조상
    if (found.size() == 2) return node;

    // [결과처리] 2. 한 자식에서 타켓 발견 : 발견된 결과 상위로 전달
    if (found.size() == 1) return found.get(0);
    return null;
  }

  // 부모를 역추적하는 방법으로 풀이하는 방법
  public String solution2(String[][] folders, String p, String q) {
    // 부모 역추적한 트리 구현
    Map<String, String> parentMap = new HashMap<>();
    for (String[] pair : folders) {
      String parent = pair[0];
      String child = pair[1];
      parentMap.put(child, parent); // child -> parent로 향하게 연결
    }

    // p의 조상들 해시테이블에 저장
    Set<String> pAncestors = new HashSet<>();
    while (p != null) {
      pAncestors.add(p);
      p = parentMap.get(p);
    }
    
    // q의 조상 중 p의 조상과 처음 겹치는 곳 찾기
    while (p != null) {
      if (pAncestors.contains(q)) {
        return q;
      }
      q = parentMap.get(q);
    }
    return "root";
  }
}
