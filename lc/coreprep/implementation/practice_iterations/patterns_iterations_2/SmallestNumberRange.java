import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SmallestNumberRange {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int m = in.nextInt();
        List<List<Integer>> a = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
          int n = in.nextInt();
          List<Integer> curr = new ArrayList<>(n);
          for (int j = 0; j < n; j++) {
            curr.add(in.nextInt());
          }
          a.add(curr);
        }

        var res = smallestNumberRange(a, m);
        System.out.printf("%d %d\n", res[0], res[1]);
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

  // O(nlogm) / O(m)
  public static int[] smallestNumberRange(List<List<Integer>> a, int m) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (e1, e2)
            -> Integer.compare(a.get(e1.arrIdx).get(e1.elemIdx),
                               a.get(e2.arrIdx).get(e2.elemIdx)));

    int start = 0, end = Integer.MAX_VALUE;
    int currMax = Integer.MIN_VALUE;

    for (int i = 0; i < m; i++) {
      minHeap.add(new Entry(i, 0));
      currMax = Math.max(currMax, a.get(i).get(0));
    }

    while (!minHeap.isEmpty()) {
      Entry entry = minHeap.poll();

      if (currMax - a.get(entry.arrIdx).get(entry.elemIdx) < end - start) {
        start = a.get(entry.arrIdx).get(entry.elemIdx);
        end = currMax;
      }

      entry.elemIdx++;
      if (entry.elemIdx < a.get(entry.arrIdx).size()) {
        minHeap.add(entry);
        currMax = Math.max(currMax, a.get(entry.arrIdx).get(entry.elemIdx));
      } else {
        break;
      }
    }

    return new int[] {start, end};
  }
}