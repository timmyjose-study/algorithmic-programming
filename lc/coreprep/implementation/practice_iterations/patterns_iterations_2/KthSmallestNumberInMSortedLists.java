import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberInMSortedLists {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int m = in.nextInt();
        int k = in.nextInt();

        List<List<Integer>> a = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
          int n = in.nextInt();

          List<Integer> curr = new ArrayList<>(n);
          for (int j = 0; j < n; j++) {
            curr.add(in.nextInt());
          }
          a.add(curr);
        }

        System.out.println(kthSmallestinMSortedLists(a, k));
      }
    }
  }

  static class Entry {
    int arrIdx;
    int elemIdx;

    Entry(int arrIdx, int elemIdx) {
      this.arrIdx = arrIdx;
      this.elemIdx = elemIdx;
    }
  }

  // O(klogm) / O(m)
  public static int kthSmallestinMSortedLists(List<List<Integer>> a, int k) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (e1, e2)
            -> Integer.compare(a.get(e1.arrIdx).get(e1.elemIdx),
                               a.get(e2.arrIdx).get(e2.elemIdx)));

    for (int i = 0; i < a.size(); i++) {
      minHeap.add(new Entry(i, 0));
    }

    while (k > 1) {
      Entry entry = minHeap.poll();
      entry.elemIdx++;

      if (entry.elemIdx < a.get(entry.arrIdx).size()) {
        minHeap.add(entry);
      }
      k--;
    }

    Entry entry = minHeap.peek();

    return a.get(entry.arrIdx).get(entry.elemIdx);
  }
}