import java.util.*;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements MyList<T> {
  private T[] arr;
  private int len;
  private int capacity;

  public DynamicArray() {
    this.len = 0;
    this.capacity = 1;
    this.arr = (T[]) new Object[this.capacity];
  }

  // O(n)
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

  // O(1)
  @Override
  public void pushBack(T elem) {
    if (this.len == this.capacity) {
      expand();
    }

    this.arr[this.len++] = elem;
  }

  private void expand() {
    this.capacity *= 2;
    T[] newArr = (T[]) new Object[this.capacity];
    System.arraycopy(arr, 0, newArr, 0, len);
    this.arr = newArr;
  }

  // O(n)
  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.arr[0];

    for (int i = 0; i < len; i++) {
      this.arr[i] = this.arr[i + 1];
    }
    this.len--;

    if (this.len < this.capacity / 2) {
      shrink();
    }

    return val;
  }

  // O(1)
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

  private void shrink() {
    this.capacity /= 2;
    T[] newArr = (T[]) new Object[this.capacity];
    System.arraycopy(arr, 0, newArr, 0, len);
    this.arr = newArr;
  }

  @Override
  public T get(int idx) {
    if (idx < 0 || idx >= this.len) {
      throw new IllegalArgumentException("invalid index");
    }

    return this.arr[idx];
  }

  // O(n)
  @Override
  public void removeElem(T elem) {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    int pos = -1;
    for (int i = 0; i < len; i++) {
      if (this.arr[i].equals(elem)) {
        pos = i;
        break;
      }
    }

    if (pos != -1) {
      for (int i = pos; i < len; i++) {
        this.arr[i] = this.arr[i + 1];
      }

      this.len--;
      if (this.len < this.capacity / 2) {
        shrink();
      }
    }
  }

  // O(1)
  @Override
  public boolean isEmpty() {
    return this.len == 0;
  }

  // O(1)
  @Override
  public int size() {
    return this.len;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.len; i++) {
      if (i > 0) {
        sb.append(" ");
      }
      sb.append(this.arr[i]);
    }

    return sb.toString();
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