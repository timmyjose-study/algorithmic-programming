import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberInMSortedLists {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        List<Integer[]> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          int m = in.nextInt();

          Integer[] a = new Integer[m];
          for (int j = 0; j < m; j++) {
            a[j] = in.nextInt();
          }
          lists.add(a);
        }

        System.out.println(kthSmallestNumberInMSortedLists(lists, k));
      }
    }
  }

  static class Entry {
    int listIndex;
    int arrayIndex;

    Entry(int listIndex, int arrayIndex) {
      this.listIndex = listIndex;
      this.arrayIndex = arrayIndex;
    }
  }

  // O(klogn) / O(n)
  public static int kthSmallestNumberInMSortedLists(List<Integer[]> lists,
                                                    int k) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (Entry e1, Entry e2)
            -> Integer.compare(lists.get(e1.listIndex)[e1.arrayIndex],
                               lists.get(e2.listIndex)[e2.arrayIndex]));

    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i) != null) {
        minHeap.add(new Entry(i, 0));
      }
    }

    int res = -1;
    while (!minHeap.isEmpty()) {
      Entry entry = minHeap.poll();
      k--;

      if (k == 0) {
        res = lists.get(entry.listIndex)[entry.arrayIndex];
        break;
      }

      entry.arrayIndex++;
      minHeap.add(entry);
    }

    return res;
  }
}