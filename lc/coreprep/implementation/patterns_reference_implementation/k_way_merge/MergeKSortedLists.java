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

  private static void display(ListNode head) {
    while (head != null) {
      System.out.printf("%d ", head.val);
      head = head.next;
    }
    System.out.println();
  }

  // O(nlogk) / O(k)
  public static ListNode mergeKSortedLists(List<ListNode> lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
        (ListNode l1, ListNode l2) -> Integer.compare(l1.val, l2.val));

    int k = lists.size();
    ListNode resHead = null, resTail = null;

    for (int i = 0; i < k; i++) {
      if (lists.get(i) != null) {
        minHeap.add(lists.get(i));
      }
    }

    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();

      if (resHead == null) {
        resHead = resTail = new ListNode(node.val);
      } else {
        resTail.next = new ListNode(node.val);
        resTail = resTail.next;
      }

      if (node.next != null) {
        node = node.next;
        minHeap.add(node);
      }
    }

    return resHead;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        List<ListNode> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          int m = in.nextInt();
          ListNode head = null, currHead = null;

          for (int j = 0; j < m; j++) {
            int val = in.nextInt();

            if (head == null) {
              head = currHead = new ListNode(val);
            } else {
              currHead.next = new ListNode(val);
              currHead = currHead.next;
            }
          }

          lists.add(head);
        }

        ListNode merged = mergeKSortedLists(lists);
        display(merged);
      }
    }
  }
}