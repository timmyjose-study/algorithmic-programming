import java.util.*;

public class DynamicArray<T> implements MyList<T> {
  private T[] arr;
  private int len;
  private int cap;

  @SuppressWarnings("unchecked")
  public DynamicArray() {
    this.len = 0;
    this.cap = 1;
    this.arr = (T[]) new Object[cap];
  }

  @SuppressWarnings("unchecked")
  private void expandArray() {
    this.cap *= 2;
    T[] newArr = (T[]) new Object[this.cap];
    System.arraycopy(this.arr, 0, newArr, 0, this.len);
    this.arr = newArr;
  }

  @SuppressWarnings("unchecked")
  private void shrinkArray() {
    this.cap /= 2;
    T[] newArr = (T[]) new Object[this.cap];
    System.arraycopy(this.arr, 0, newArr, 0, this.len);
    this.arr = newArr;
  }

  @Override
  public void pushFront(T elem) {
    if (this.len == this.cap) {
      expandArray();
    }

    for (int i = this.len; i > 0; i--) {
      this.arr[i] = this.arr[i - 1];
    }

    this.arr[0] = elem;
    this.len++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.len == this.cap) {
      expandArray();
    }

    this.arr[this.len++] = elem;
  }

  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.arr[0];
    if (this.len < this.cap / 2) {
      shrinkArray();
    }

    for (int i = 0; i < this.len; i++) {
      this.arr[i] = this.arr[i + 1];
    }
    this.len--;

    return val;
  }

  @Override
  public T popBack() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.arr[this.len - 1];
    this.len--;

    if (this.len < this.cap / 2) {
      shrinkArray();
    }

    return val;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= this.len) {
      throw new IllegalStateException("invalid index for list");
    }

    return this.arr[index];
  }

  @Override
  public void removeElem(T elem) {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    if (elem == this.arr[0]) {
      popFront();
    } else if (elem == this.arr[this.len - 1]) {
      popBack();
    } else {
      int elemIdx = -1;
      for (int i = 0; i < this.len; i++) {
        if (this.arr[i].equals(elem)) {
          elemIdx = i;
          break;
        }
      }

      if (elemIdx != -1) {
        for (int i = elemIdx; i < this.len; i++) {
          this.arr[i] = this.arr[i + 1];
        }
        this.len--;

        if (this.len < this.cap / 2) {
          shrinkArray();
        }
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
      sb.append(this.arr[i] + " ");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyList<Integer> dynArr = new DynamicArray<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "popfront":
          System.out.printf("%d ", dynArr.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dynArr.popBack());
          break;

        case "pushfront":
          dynArr.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "pushback":
          dynArr.pushBack(Integer.parseInt(cmd[1]));
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

        case "removeelem":
          dynArr.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "newline":
          System.out.println();
          break;

        case "print":
          System.out.println(dynArr);
          break;
        }
      }
    }
  }
}