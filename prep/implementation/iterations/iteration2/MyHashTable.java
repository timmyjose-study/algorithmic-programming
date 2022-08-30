import java.util.*;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MyHashTable {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      HashTable<Integer, Integer> ht = new HashTable<>();

      int nq = in.nextInt();
      in.nextLine();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "isempty":
          System.out.println(ht.isEmpty());
          break;

        case "insert": {
          int key = Integer.parseInt(cmd[1]);
          int value = Integer.parseInt(cmd[2]);
          ht.insert(key, value);
        } break;

        case "print":
          System.out.println(ht);
          break;

        case "size":
          System.out.println(ht.size());
          break;

        case "loadfactor":
          System.out.println(ht.loadFactor());
          break;

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
        }
      }
    }
  }
}