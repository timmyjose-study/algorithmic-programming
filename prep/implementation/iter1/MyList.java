public interface MyList<T> {
  void pushFront(T elem);
  void pushBack(T elem);
  T popFront();
  T popBack();
  T get(int index);
  void removeElem(T elem);
  boolean isEmpty();
  int size();
}