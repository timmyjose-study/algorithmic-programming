import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        ListNode reversedHead = reverse(head);
        display(reversedHead);
      }
    }
  }

  // O(n) / O(1)
  public static ListNode reverse(ListNode head) {
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