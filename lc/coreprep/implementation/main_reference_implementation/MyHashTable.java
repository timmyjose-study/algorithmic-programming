import java.util.*;

public class MyHashTable {
  @SuppressWarnings({"rawtypes", "unchecked"})
  static class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 1;
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
        this.prev = prev;
        this.next = next;
      }

      @Override
      public String toString() {
        return String.format("(%s, %s)", this.key, this.value);
      }
    }

    private Node<K, V>[] table;
    private int size;
    private int capacity;

    HashTable() {
      this.table = new Node[HashTable.DEFAULT_CAPACITY];
      this.capacity = HashTable.DEFAULT_CAPACITY;
      this.size = 0;
    }

    private int hash(K key) {
      int hash = Objects.hash(key);

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
      this.size++;

      if (loadFactor() > HashTable.MAX_LOAD_FACTOR) {
        expandAndRehash();
      }
    }

    private void insert(Node<K, V>[] table, K key, V value) {
      int hash = hash(key);

      if (table[hash] == null) {
        table[hash] = new Node<>(key, value);
      } else {
        Node<K, V> currNode = table[hash];
        while (currNode.next != null) {
          currNode = currNode.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        currNode.next = newNode;
        newNode.prev = currNode;
      }
    }

    private void expandAndRehash() {
      this.capacity *= 2;
      Node<K, V>[] newTable = new Node[this.capacity];

      for (int i = 0; i < this.size; i++) {
        Node<K, V> currNode = this.table[i];

        while (currNode != null) {
          insert(newTable, currNode.key, currNode.value);
          currNode = currNode.next;
        }
      }

      this.table = newTable;
    }

    public boolean containsKey(K key) {
      int hash = hash(key);

      if (this.table[hash] == null) {
        return false;
      }

      Node<K, V> currNode = this.table[hash];
      while (currNode != null && !currNode.key.equals(key)) {
        currNode = currNode.next;
      }

      if (currNode == null) {
        return false;
      }

      return true;
    }

    public V get(K key) {
      int hash = hash(key);

      if (this.table[hash] == null) {
        return null;
      }

      Node<K, V> currNode = this.table[hash];
      while (currNode != null && !currNode.key.equals(key)) {
        currNode = currNode.next;
      }

      if (currNode == null) {
        return null;
      }

      return currNode.value;
    }

    public void remove(K key) {
      boolean removed = remove(this.table, key);

      if (removed) {
        this.size--;
      }

      if (loadFactor() < HashTable.MIN_LOAD_FACTOR) {
        shrinkAndRehash();
      }
    }

    private boolean remove(Node<K, V>[] table, K key) {
      int hash = hash(key);

      if (table[hash] == null) {
        return false;
      }

      if (this.table[hash].key.equals(key)) {
        table[hash] = null;
      } else {
        Node<K, V> currNode = table[hash];
        while (currNode != null && !currNode.key.equals(key)) {
          currNode = currNode.next;
        }

        if (currNode == null) {
          return false;
        }

        currNode.prev.next = currNode.next;
        if (currNode.next != null) {
          currNode.next.prev = currNode.prev;
        }
      }

      return true;
    }

    private void shrinkAndRehash() {
      this.capacity /= 2;
      Node<K, V>[] newTable = new Node[this.capacity];

      for (int i = 0; i < size; i++) {
        Node<K, V> currNode = this.table[i];
        while (currNode != null) {
          insert(newTable, currNode.key, currNode.value);
          currNode = currNode.next;
        }
      }

      this.table = newTable;
    }

    public boolean isEmpty() { return this.size == 0; }

    public int size() { return this.size; }

    public double loadFactor() { return (double)this.size / this.capacity; }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < this.capacity; i++) {
        sb.append(i).append(": ");
        Node<K, V> currNode = this.table[i];
        while (currNode != null) {
          sb.append(currNode).append(" ");
          currNode = currNode.next;
        }
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      HashTable<Integer, Integer> ht = new HashTable<>();

      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "insert": {
          int key = Integer.parseInt(cmd[1]);
          int value = Integer.parseInt(cmd[2]);

          ht.insert(key, value);
        } break;

        case "present": {
          int key = Integer.parseInt(cmd[1]);
          System.out.println(ht.containsKey(key));
        } break;

        case "get": {
          int key = Integer.parseInt(cmd[1]);
          System.out.println(ht.get(key));

        } break;

        case "remove": {
          int key = Integer.parseInt(cmd[1]);
          ht.remove(key);
        } break;

        case "isempty":
          System.out.println(ht.isEmpty());
          break;

        case "size":
          System.out.println(ht.size());
          break;

        case "loadfactor":
          System.out.println(ht.loadFactor());
          break;

        case "print":
          System.out.println(ht);
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}