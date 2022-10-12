import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class MiddleOfTheLinkedList {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  private static int middleOfTheLinkedList(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return -1;
      }
    }
    return slow.val;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= n; i++) {
          curr.next = new ListNode(i);
          curr = curr.next;
        }

        if (k != -1) {
          ListNode tmp = head;
          for (int j = 0; j < k - 1; j++) {
            tmp = tmp.next;
          }
          curr.next = tmp;
        }

        System.out.println(middleOfTheLinkedList(head));
      }
    }
  }
}