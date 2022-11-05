import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ReverseFirstKElements {
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

        ListNode head = null, tail = null;
        for (int i = 0; i < n; i++) {
          int val = in.nextInt();

          if (head == null) {
            head = tail = new ListNode(val);
          } else {
            tail.next = new ListNode(val);
            tail = tail.next;
          }
        }

        ListNode reversedHead = reverseFirstK(head, k);
        display(reversedHead);
      }
    }
  }

  public static ListNode reverseFirstK(ListNode head, int k) {
    return reverse(head, 1, k);
  }

  // O(n) / O(1)
  private static ListNode reverse(ListNode head, int p, int q) {
    ListNode beforeFrom = null, from = head, to = head, afterTo = null;

    for (int i = 0; i < p - 1; i++) {
      beforeFrom = from;
      from = from.next;
    }

    for (int i = 0; i < q - 1; i++) {
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
}