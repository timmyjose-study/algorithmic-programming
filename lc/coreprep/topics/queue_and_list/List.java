public interface List<T> {
  void pushFront(T elem);
  void pushBack(T elem);
  T popFront() throws ListEmptyException;
  T popBack() throws ListEmptyException;
  void removeElem(T elem) throws ListEmptyException;
  void removeIndex(int index) throws ListEmptyException;
  boolean isEmpty();
  int size();
}