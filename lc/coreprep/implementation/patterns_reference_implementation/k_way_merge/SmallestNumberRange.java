import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SmallestNumberRange {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int m = in.nextInt();

        List<Integer[]> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
          int n = in.nextInt();

          Integer[] a = new Integer[n];
          for (int j = 0; j < n; j++) {
            a[j] = in.nextInt();
          }
          lists.add(a);
        }

        Range minRange = smallestNumberRange(lists);
        System.out.printf("%d %d\n", minRange.start(), minRange.end());
      }
    }
  }

  record Range(int start, int end) {}

  static class Entry {
    int listIndex;
    int arrIndex;

    Entry(int listIndex, int arrIndex) {
      this.listIndex = listIndex;
      this.arrIndex = arrIndex;
    }
  }

  // O(nlogm) / O(m)
  public static Range smallestNumberRange(List<Integer[]> lists) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(
        (Entry e1, Entry e2)
            -> Integer.compare(lists.get(e1.listIndex)[e1.arrIndex],
                               lists.get(e2.listIndex)[e2.arrIndex]));

    int currStart = Integer.MIN_VALUE0, currEnd = Integer.MAX_VALUE;
    int currMax = Integer.MIN_VALUE;
    for (int i = 0; i < lists.size(); i++) {
      minHeap.add(new Entry(i, 0));
      currMax = Math.max(currMax, lists.get(i)[0]);
    }

    while (minHeap.size() == lists.size()) {
      Entry entry = minHeap.poll();

      if (currMax - lists.get(entry.listIndex)[entry.arrIndex] <
          currEnd - currStart) {
        currStart = lists.get(entry.listIndex)[entry.arrIndex];
        currEnd = currMax;
      }

      entry.arrIndex++;

      if (entry.arrIndex < lists.get(entry.listIndex).length) {
        minHeap.add(entry);
        currMax = Math.max(currMax, lists.get(entry.listIndex)[entry.arrIndex]);
      }
    }

    return new Range(currStart, currEnd);
  }
}