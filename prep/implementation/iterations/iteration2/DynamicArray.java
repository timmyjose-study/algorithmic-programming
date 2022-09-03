import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DynamicArray<T extends Comparable<T>> implements MyList<T> {
  private T[] arr;
  private int len;
  private int capacity;

  private static final int DEFAULT_CAPACITY = 1;

  public DynamicArray() {
    this.len = 0;
    this.capacity = DynamicArray.DEFAULT_CAPACITY;
    this.arr = (T[]) new Comparable[this.capacity];
  }

  private void expand() {
    this.capacity *= 2;
    T[] newArr = (T[]) new Comparable[this.capacity];
    System.arraycopy(this.arr, 0, newArr, 0, this.len);
    this.arr = newArr;
  }

  private void shrink() {
    this.capacity /= 2;
    T[] newArr = (T[]) new Comparable[this.capacity];
    System.arraycopy(this.arr, 0, newArr, 0, this.len);
    this.arr = newArr;
  }

  @Override
  public void pushFront(T elem) {
    if (this.len == this.capacity) {
      expand();
    }

    for (int i = this.len; i > 0; i--) {
      this.arr[i] = this.arr[i - 1];
    }
    this.arr[0] = elem;
    this.len++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.len == this.capacity) {
      expand();
    }

    this.arr[this.len++] = elem;
  }

  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.arr[0];
    for (int i = 0; i < this.len - 1; i++) {
      this.arr[i] = this.arr[i + 1];
    }

    this.len--;
    if (this.len < this.capacity / 2) {
      shrink();
    }

    return val;
  }

  @Override
  public T popBack() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.arr[this.len - 1];
    this.len--;

    if (this.len < this.capacity / 2) {
      shrink();
    }

    return val;
  }

  @Override
  public T get(int idx) {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    if (idx < 0 || idx >= this.len) {
      throw new IllegalStateException("invalid index");
    }

    return this.arr[idx];
  }

  @Override
  public void removeElem(T elem) {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    int pos = -1;
    for (int i = 0; i < this.len; i++) {
      if (this.arr[i].compareTo(elem) == 0) {
        pos = i;
        break;
      }
    }

    if (pos != -1) {
      for (int i = pos; i < this.len; i++) {
        this.arr[i] = this.arr[i + 1];
      }
      this.len--;

      if (this.len < this.capacity / 2) {
        shrink();
      }
    }
  }

  @Override
  public int size() {
    return this.len;
  }

  @Override
  public boolean isEmpty() {
    return this.len == 0;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.len; i++) {
      sb.append(this.arr[i]).append(" ");
    }

    return sb.toString().trim();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyList<Integer> dynArr = new DynamicArray<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", dynArr.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dynArr.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.removeElem(elem);
        } break;

        case "print":
          System.out.println(dynArr);
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopfront":
          while (!dynArr.isEmpty()) {
            System.out.printf("%d ", dynArr.popFront());
          }
          break;

        case "tillemptypopback":
          while (!dynArr.isEmpty()) {
            System.out.printf("%d ", dynArr.popBack());
          }
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}