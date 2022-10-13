import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class ReverseEvenOdd {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = next;
    }
  }

  private static ListNode reverse(ListNode head, int fromPos, int toPos) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode beforeFrom = null, from = head, to = head, afterTo = null;

    for (int i = 0; i < fromPos - 1; i++) {
      beforeFrom = from;
      from = from.next;
    }

    for (int i = 0; i < toPos - 1; i++) {
      to = to.next;
    }
    afterTo = to.next;

    ListNode prev = afterTo, curr = from, next = null;
    while (curr != afterTo) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    if (beforeFrom == null) {
      head = prev;
    } else {
      beforeFrom.next = prev;
    }

    return head;
  }

  private static void display(ListNode head) {
    while (head != null) {
      System.out.printf("%d ", head.val);
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        ListNode head = new ListNode(in.nextInt());
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
          curr.next = new ListNode(in.nextInt());
          curr = curr.next;
        }

        if (n % 2 == 0) {
          head = reverse(head, 1, n / 2);
          head = reverse(head, n / 2 + 1, n);
        } else {
          head = reverse(head, 1, n / 2);
          head = reverse(head, n / 2 + 2, n);
        }

        display(head);
      }
    }
  }
}