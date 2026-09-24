import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);

    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children = new ArrayList<>();
    child1.children.add(child1_1);
    child1.children.add(child1_2);

    Node<Integer> child2_1 = new Node<>(73);
    child2.children = new ArrayList<>();
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children = new ArrayList<>();
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);

    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children = new ArrayList<>();
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);
    //

    Map<Integer,List<Integer>> tree = new HashMap<>();
    tree.put(88, List.of(17,58,33));
    tree.put(17, List.of(5,99));
    tree.put(58, List.of(73));
    tree.put(33, List.of(24,61,12));
    tree.put(24, List.of(83,6));

    // preorder(root);
    // preorderMap(tree, 88);
    System.out.println(byLevel(root));
    System.out.println(sum(root));
  }

  public static <T> void preorderMap(Map<T,List<T>> tree, T node) {
    if (tree == null || node == null) return;
    System.out.println(node);

    if (tree.containsKey(node));
    for (T child : tree.get(node)) preorderMap(tree, child);
  }

  public static void preorder(Node<?> node) {
    if (node == null) return;
    System.out.println(node.value);

    for (Node<?> child : node.children) preorder(child);
  }

  public static int sum(Node<Integer> node) {
    if (node == null) return 0;
    int sum = node.value;
    
    for (Node<Integer> child : node.children) sum += sum(child);
    return sum;
  }

  public static <T> List<List<T>> byLevel(Node<T> root) {
    List<List<T>> levelOrder = new ArrayList<>();
    if (root == null) return levelOrder;
    Queue<Node<T>> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<T> level = new ArrayList<T>();
      for (int i=0;i<size;i++) {
        Node<T> node = queue.poll();
        level.add(node.value);
        for (Node<T> child : node.children) queue.offer(child);
      }
      levelOrder.add(level);
    }

    return levelOrder;
  }
}
