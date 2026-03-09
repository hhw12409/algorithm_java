package 자료구조;

import java.util.ArrayList;

public class ArrayExample {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.get(0); // O(1)
    list.set(1, 9); // O(1)
    list.add(4); // O(1)
    list.add(5); // O(1)
    list.remove(list.size() - 1); // O(1)
    list.add(1, 10); // O(n)
    list.remove(2); // O(n)
    list.contains(4); // O(n)
    list.remove(Integer.valueOf(4)); // O(n)
  }
}
