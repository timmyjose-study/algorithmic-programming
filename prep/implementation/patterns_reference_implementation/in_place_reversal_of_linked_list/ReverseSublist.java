import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class ReverseSublist {
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
        int from = in.nextInt();
        int to = in.nextInt();

        int val = in.nextInt();
        ListNode head = new ListNode(val);
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
          val = in.nextInt();
          curr.next = new ListNode(val);
          curr = curr.next;
        }

        head = reverse(head, from, to);
        display(head);
      }
    }
  }

  private static ListNode reverse(ListNode head, int from, int to) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode beforeStart = null, start = head, end = head, afterEnd = null;

    for (int i = 0; i < from - 1; i++) {
      beforeStart = start;
      start = start.next;
    }

    for (int j = 0; j < to - 1; j++) {
      end = end.next;
    }
    afterEnd = end.next;

    ListNode prev = null, curr = start, next = null;
    while (curr != afterEnd) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    if (beforeStart == null) {
      head = prev;
    } else {
      beforeStart.next = prev;
    }
    start.next = afterEnd;

    return head;
  }

  private static void display(ListNode head) {
    while (head != null) {
      System.out.printf("%d ", head.val);
      head = head.next;
    }
    System.out.println();
  }
}