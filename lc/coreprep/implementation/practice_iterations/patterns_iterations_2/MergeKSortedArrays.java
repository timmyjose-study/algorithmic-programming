import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MergeKSortedArrays {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int k = in.nextInt();

        List<List<Integer>> a = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
          int n = in.nextInt();

          List<Integer> curr = new ArrayList<>(n);
          for (int j = 0; j < n; j++) {
            curr.add(in.nextInt());
          }
          a.add(curr);
        }

        var res = mergeKSortedArrays(a, k);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
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

  // O(nlogk) / O(k)
  public static List<Integer> mergeKSortedArrays(List<List<Integer>> a, int k) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (e1, e2)
            -> Integer.compare(a.get(e1.arrIdx).get(e1.elemIdx),
                               a.get(e2.arrIdx).get(e2.elemIdx)));

    for (int i = 0; i < k; i++) {
      minHeap.add(new Entry(i, 0));
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      Entry entry = minHeap.poll();

      res.add(a.get(entry.arrIdx).get(entry.elemIdx));
      entry.elemIdx++;

      if (entry.elemIdx < a.get(entry.arrIdx).size()) {
        minHeap.add(entry);
      }
    }

    return res;
  }
}