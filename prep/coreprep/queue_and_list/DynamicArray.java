public class DynamicArray<T> implements List<T> {
  private T[] arr;
  private int len;
  private int cap;

  @SuppressWarnings("unchecked")
  public DynamicArray() {
    this.arr = (T[]) new Object[1];
    this.len = 0;
    this.cap = 1;
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
  @SuppressWarnings("unchecked")
  public void pushFront(T elem) {
    if (this.len == this.cap) {
      this.cap *= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    for (int i = this.len; i > 0; i--) {
      this.arr[i] = this.arr[i - 1];
    }

    this.arr[0] = elem;
    this.len++;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void pushBack(T elem) {
    if (this.len == this.cap) {
      this.cap *= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    this.arr[this.len++] = elem;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T popFront() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    T data = this.arr[0];
    for (int i = 0; i < this.len - 1; i++) {
      this.arr[i] = this.arr[i + 1];
    }

    if (this.len < this.cap / 2) {
      this.cap /= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    this.len--;

    return data;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T popBack() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    T data = this.arr[this.len - 1];
    this.len--;

    if (this.len < this.cap / 2) {
      this.cap /= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    return data;
  }

  @Override
  public void removeElem(T elem) throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    int index = -1;
    for (int i = 0; i < this.len; i++) {
      if (this.arr[i].equals(elem)) {
        index = i;
        break;
      }
    }

    if (index != -1) {
      removeIndex(index);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public void removeIndex(int index) throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    if (index < 0 || index > this.len) {
      throw new ArrayIndexOutOfBoundsException();
    }

    for (int i = index; i < this.len; i++) {
      this.arr[i] = this.arr[i + 1];
    }

    if (this.len < this.cap / 2) {
      this.cap /= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    this.len--;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < this.len; i++) {
      sb.append(this.arr[i]).append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    List<Integer> dynArr = new DynamicArray<>();
    for (int i = 0; i < 5; i++) {
      dynArr.pushFront(i);
    }

    while (!dynArr.isEmpty()) {
      System.out.printf("%d ", dynArr.popFront());
    }
    System.out.println();

    for (int i = 5; i < 10; i++) {
      dynArr.pushBack(i);
    }

    while (!dynArr.isEmpty()) {
      System.out.printf("%d ", dynArr.popBack());
    }
    System.out.println();

    for (int i = 0, j = 1; i < 10; i++, j++) {
      dynArr.pushFront(i);
      dynArr.pushBack(j);
    }

    while (true) {
      System.out.printf("%d ", dynArr.popFront());
      if (dynArr.isEmpty()) {
        break;
      }

      System.out.printf("%d ", dynArr.popBack());
      if (dynArr.isEmpty()) {
        break;
      }
    }
    System.out.println();

    dynArr.pushBack(100);
    dynArr.pushBack(200);
    dynArr.pushBack(300);
    dynArr.pushBack(400);
    dynArr.pushBack(500);
    dynArr.pushBack(200);
    System.out.println(dynArr);

    dynArr.removeElem(200);
    System.out.println(dynArr);

    dynArr.removeElem(200);
    System.out.println(dynArr);

    dynArr.removeElem(100);
    System.out.println(dynArr);

    dynArr.removeElem(400);
    System.out.println(dynArr);

    dynArr.removeElem(300);
    System.out.println(dynArr);

    dynArr.removeElem(500);
    System.out.println(dynArr);
  }
}