import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MergeKSortedLists {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int k = in.nextInt();

        List<ListNode> a = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
          int n = in.nextInt();

          ListNode head = null, tail = null;
          for (int j = 0; j < n; j++) {
            int val = in.nextInt();

            if (head == null) {
              head = tail = new ListNode(val);
            } else {
              tail.next = new ListNode(val);
              tail = tail.next;
            }
          }

          a.add(head);
        }

        var res = mergeKSortedLists(a, k);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(nlogk) / O(k)
  public static List<Integer> mergeKSortedLists(List<ListNode> a, int k) {
    PriorityQueue<ListNode> minHeap =
        new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));

    for (int i = 0; i < k; i++) {
      minHeap.add(a.get(i));
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      ListNode curr = minHeap.poll();

      res.add(curr.val);
      curr = curr.next;

      if (curr != null) {
        minHeap.add(curr);
      }
    }

    return res;
  }
}