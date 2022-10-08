import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class ReverseLinkedList {
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

        int val = in.nextInt();
        ListNode head = new ListNode(val);
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
          val = in.nextInt();
          curr.next = new ListNode(val);
          curr = curr.next;
        }

        head = reverse(head);
        display(head);
      }
    }
  }

  private static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  private static void display(ListNode head) {
    while (head != null) {
      System.out.printf("%d ", head.val);
      head = head.next;
    }
    System.out.println();
  }
}