import java.util.Objects;

public class HashTable<K extends Comparable<K>, V> {
  private static final int INITIAL_CAPACITY = 1;
  private static final double MIN_LOAD_FACTOR = 0.2;
  private static final double MAX_LOAD_FACTOR = 0.75;

  static class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.prev = this.next = null;
    }

    @Override
    public String toString() {
      return "(" + this.key + ", " + this.value + ")";
    }
  }

  private Node<K, V>[] table;
  private int capacity;
  private int size;

  @SuppressWarnings({"rawtypes", "unchecked"})
  public HashTable() {
    this.table = new Node[HashTable.INITIAL_CAPACITY];
    this.capacity = HashTable.INITIAL_CAPACITY;
    this.size = 0;
  }

  private int hash(K key) {
    int hash = Objects.hashCode(key);

    if (hash < 0) {
      hash = -hash;
    }

    return hash % this.capacity;
  }

  public void insert(K key, V value) {
    if (containsKey(key)) {
      return;
    }

    insert(this.table, key, value);

    if (loadFactor() > HashTable.MAX_LOAD_FACTOR) {
      rehashExpand();
    }

    this.size++;
  }

  private void insert(Node<K, V>[] table, K key, V value) {
    int hash = hash(key);

    if (table[hash] == null) {
      table[hash] = new Node<>(key, value);
    } else {
      Node<K, V> curr = table[hash];
      while (curr.next != null) {
        curr = curr.next;
      }

      Node<K, V> node = new Node<>(key, value);
      curr.next = node;
      node.prev = curr;
    }
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private void rehashExpand() {
    int oldCapacity = this.capacity;
    this.capacity *= 2;

    Node<K, V>[] newTable = new Node[this.capacity];
    for (int i = 0; i < oldCapacity; i++) {
      Node<K, V> node = this.table[i];
      while (node != null) {
        insert(newTable, node.key, node.value);
        node = node.next;
      }
    }

    this.table = null;
    this.table = newTable;
  }

  public void remove(K key) {
    boolean removed = remove(this.table, key);

    if (removed) {
      if (loadFactor() < HashTable.MIN_LOAD_FACTOR) {
        rehashShrink();
      }
      this.size--;
    }
  }

  private boolean remove(Node<K, V>[] table, K key) {
    int hash = hash(key);

    Node<K, V> node = this.table[hash];
    while (node != null && !node.key.equals(key)) {
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    // single node
    if (node.prev == null && node.next == null) {
      this.table[hash] = null;
    } else if (node.prev == null) { // head node
      this.table[hash] = node.next;
      this.table[hash].prev = null;
    } else {
      node.prev.next = node.next;
      if (node.next != null) {
        node.next.prev = node.prev;
      }
    }

    return true;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private void rehashShrink() {
    int oldCapacity = this.capacity;
    this.capacity /= 2;

    Node<K, V>[] newTable = new Node[this.capacity];
    for (int i = 0; i < oldCapacity; i++) {
      Node<K, V> node = this.table[i];
      while (node != null) {
        insert(newTable, node.key, node.value);
        node = node.next;
      }
    }

    this.table = newTable;
  }

  public boolean containsKey(K key) {
    if (isEmpty()) {
      return false;
    }

    int hash = hash(key);

    Node<K, V> node = this.table[hash];
    while (node != null && !node.key.equals(key)) {
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    return true;
  }

  public V get(K key) {
    int hash = key.hashCode();

    Node<K, V> node = this.table[hash];
    while (node != null && !node.key.equals(key)) {
      node = node.next;
    }

    if (node == null) {
      return null;
    }

    return node.value;
  }

  public double loadFactor() { return (double)this.size / this.capacity; }
  public int size() { return this.size; }
  public boolean isEmpty() { return this.size == 0; }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.capacity; i++) {
      sb.append(i).append(": ");
      Node<K, V> node = this.table[i];
      while (node != null) {
        sb.append(node).append(" ");
        node = node.next;
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    HashTable<Integer, Integer> intmap = new HashTable<>();

    intmap.insert(1, 1);
    intmap.insert(1, 1);
    intmap.insert(1, 1);
    intmap.insert(2, 2);
    intmap.insert(3, 3);

    System.out.println(intmap);
    System.out.println("size = " + intmap.size());
    System.out.println("loadFactor = " + intmap.loadFactor());

    System.out.printf("Is %d present? %s\n", 1, intmap.containsKey(1));
    if (intmap.containsKey(1)) {
      System.out.printf("%d => %d\n", 1, intmap.get(1));
    }
    System.out.printf("Is %d present? %s\n", 100, intmap.containsKey(100));

    intmap.remove(1);
    System.out.printf("Is %d present? %s\n", 1, intmap.containsKey(1));
    if (intmap.containsKey(1)) {
      System.out.printf("%d => %d\n", 1, intmap.get(1));
    }

    intmap.remove(1);
    System.out.println(intmap);
    System.out.println("size = " + intmap.size());
    System.out.println("loadFactor = " + intmap.loadFactor());

    intmap.remove(1);
    System.out.println(intmap);
    System.out.println("size = " + intmap.size());
    System.out.println("loadFactor = " + intmap.loadFactor());

    intmap.remove(2);
    intmap.remove(3);
    System.out.println(intmap);
    System.out.printf("Is intmap empty? %s\n", intmap.isEmpty());

    HashTable<String, Integer> strMap = new HashTable<>();
    strMap.insert("Hello", 5);
    strMap.insert("World", 5);
    strMap.insert("Again", 100);
    strMap.insert("Again", 100);
    System.out.println(strMap);

    // stress test
    for (int i = 0; i < 1_000_000; i++) {
      intmap.insert(i, i);
    }

    System.out.printf("intmap size = %d, loadFactor = %.2f\n", intmap.size(),
                      intmap.loadFactor());

    for (int i = 0; i < 1_000_000; i++) {
      intmap.remove(i);
    }

    if (!intmap.isEmpty()) {
      throw new IllegalStateException("intmap is not empty!");
    }
  }
}