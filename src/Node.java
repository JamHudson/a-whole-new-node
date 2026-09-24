import java.util.ArrayList;
import java.util.List;

public class Node<T> {
  T value;
  List<Node<T>> children;
  
  public Node(T value) {
    this.value = value;
    this.children = new ArrayList<>();
  }
}