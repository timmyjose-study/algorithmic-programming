import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MergeKSortedArrays {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        List<Integer[]> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          int m = in.nextInt();

          Integer[] a = new Integer[m];
          for (int j = 0; j < m; j++) {
            a[j] = in.nextInt();
          }
          lists.add(a);
        }

        var sorted = mergeKSortedArrays(lists);
        for (int s : sorted) {
          System.out.printf("%d ", s);
        }
        System.out.println();
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

  // O(nlogk) / O(k)
  public static List<Integer> mergeKSortedArrays(List<Integer[]> lists) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (Entry e1, Entry e2)
            -> Integer.compare(lists.get(e1.listIndex)[e1.arrayIndex],
                               lists.get(e2.listIndex)[e2.arrayIndex]));

    int k = lists.size();
    for (int i = 0; i < k; i++) {
      if (lists.get(i) != null) {
        minHeap.add(new Entry(i, 0));
      }
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      Entry entry = minHeap.poll();

      res.add(lists.get(entry.listIndex)[entry.arrayIndex]);
      if (entry.arrayIndex < lists.get(entry.listIndex).length - 1) {
        entry.arrayIndex++;
        minHeap.add(entry);
      }
    }

    return res;
  }
}