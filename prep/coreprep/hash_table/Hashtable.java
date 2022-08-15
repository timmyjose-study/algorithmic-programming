import java.util.*;

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
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      HashTable<Integer, Integer> intmap = new HashTable<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "insert":
          intmap.insert(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
          break;

        case "remove":
          intmap.remove(Integer.parseInt(cmd[1]));
          break;

        case "isempty":
          System.out.println(intmap.isEmpty());
          break;

        case "print":
          System.out.println(intmap);
          break;

        case "size":
          System.out.println(intmap.size());
          break;

        case "loadfactor":
          System.out.println(intmap.loadFactor());
          break;
        }
      }
    }
  }
}