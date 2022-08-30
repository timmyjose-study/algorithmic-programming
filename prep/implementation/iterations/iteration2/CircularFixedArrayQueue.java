import java.util.*;

@SuppressWarnings("unchecked")
public class CircularFixedArrayQueue<T> implements MyQueue<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int size = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new CircularFixedArrayQueue<>(size);
    }
  }
}