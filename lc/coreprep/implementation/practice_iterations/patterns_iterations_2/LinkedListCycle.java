import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LinkedListCycle {
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
        int n = in.nextInt();
        int k = in.nextInt();

        ListNode head = new ListNode(1);
        ListNode tail = head;

        for (int i = 2; i <= n; i++) {
          tail.next = new ListNode(i);
          tail = tail.next;
        }

        if (k != -1) {
          ListNode tmp = head;
          for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
          }
          tail.next = tmp;
        }

        System.out.println(hasCycle(head));
      }
    }
  }

  // O(n) / O(1)
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}