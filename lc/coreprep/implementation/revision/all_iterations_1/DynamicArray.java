import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class DynamicArray {
  @SuppressWarnings({"unchecked", "rawtypes"})
  static class DynArr<T extends Comparable<T>> {
    private T[] arr;
    private int len;
    private int capacity;

    DynArr() {
      this.len = 0;
      this.capacity = 1;
      this.arr = (T[]) new Comparable[this.capacity];
    }

    private void expand() {
      T[] newArr = (T[]) new Comparable[this.capacity * 2];
      System.arraycopy(this.arr, 0, newArr, 0, this.capacity);
      this.capacity *= 2;
      this.arr = newArr;
    }

    private void shrink() {
      this.capacity /= 2;
      T[] newArr = (T[]) new Comparable[this.capacity];
      System.arraycopy(this.arr, 0, newArr, 0, this.capacity);
      this.arr = newArr;
    }

    // O(n)
    public void pushFront(T elem) {
      if (this.len == this.capacity) {
        expand();
      }

      for (int i = this.len; i > 0; i--) {
        this.arr[i] = this.arr[i - 1];
      }
      this.len++;

      this.arr[0] = elem;
    }

    // O(n)
    public T popFront() {
      if (isEmpty()) {
        throw new RuntimeException("dynamic array is empty");
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

    // O(1)
    public void pushBack(T elem) {
      if (this.len == this.capacity) {
        expand();
      }

      this.arr[this.len++] = elem;
    }

    // O(1)
    public T popBack() {
      if (isEmpty()) {
        throw new RuntimeException("dynamic array is empty");
      }

      T val = this.arr[this.len - 1];
      this.len--;

      if (this.len < this.capacity / 2) {
        shrink();
      }

      return val;
    }

    // O(n)
    public void removeElem(T elem) {
      int elemPos = -1;
      for (int i = 0; i < this.len; i++) {
        if (this.arr[i].compareTo(elem) == 0) {
          elemPos = i;
          break;
        }
      }

      if (elemPos != -1) {
        for (int i = elemPos; i < this.len; i++) {
          this.arr[i] = this.arr[i + 1];
        }
        this.len--;

        if (this.len < this.capacity / 2) {
          shrink();
        }
      }
    }

    // O(1)
    public int size() { return this.len; }

    // O(1)
    public boolean isEmpty() { return this.len == 0; }

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
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();
      DynArr<Integer> arr = new DynArr<>();

      while (tt-- > 0) {
        String[] cmd = in.nextLine().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          arr.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          arr.pushBack(elem);
        } break;

        case "popfront":
          System.out.print(arr.popFront() + " ");
          break;

        case "tillemptypopfront":
          while (!arr.isEmpty()) {
            System.out.print(arr.popFront() + " ");
          }
          break;

        case "popback":
          System.out.print(arr.popBack() + " ");
          break;

        case "tillemptypopback":
          while (!arr.isEmpty()) {
            System.out.print(arr.popBack() + " ");
          }
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          arr.removeElem(elem);
        } break;

        case "print":
          System.out.println(arr.toString());
          break;

        case "newline":
          System.out.println();
          break;

        default:
          throw new IllegalArgumentException(cmd[0]);
        }
      }
    }
  }
}