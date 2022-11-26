import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumNumberOfJumpsBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(minJumps(a));
      }
    }
  }

  // O(2n) / O(n)
  public static int minJumps(int[] a) { return minJumps(a, 0); }

  private static int minJumps(int[] a, int currIdx) {
    if (currIdx == a.length - 1) {
      return 0;
    }

    if (a[currIdx] == 0) {
      return Integer.MAX_VALUE;
    }

    int currMinJumps = Integer.MAX_VALUE;
    int start = currIdx + 1;
    int end = currIdx + a[currIdx];

    while (start < a.length && start <= end) {
      int nextMinJumps = minJumps(a, start);
      if (nextMinJumps != Integer.MAX_VALUE) {
        currMinJumps = Math.min(currMinJumps, 1 + nextMinJumps);
      }
      start++;
    }

    return currMinJumps;
  }
}