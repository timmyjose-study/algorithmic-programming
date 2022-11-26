import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// Solved
public class MaxLengthPrefix {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int nq = in.nextInt();
        int[] qs = new int[nq];
        for (int i = 0; i < nq; i++) {
          qs[i] = in.nextInt();
        }

        var res = solve(n, a, nq, qs);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  static int[] solve(int N, int[] A, int Q, int[] queries) {
    int cnt = 0;
    for (int q : queries) {
      if (q == 2) {
        cnt++;
      }
    }

    int[] res = new int[cnt];

    int oneCount = 0;
    for (int e : A) {
      if (e == 1) {
        oneCount++;
      }
    }

    if (oneCount == N) {
      Arrays.fill(res, oneCount);
      return res;
    }

    int idx = 0;
    int maxPrefix = 0;
    for (int i = 0; i < N; i++) {
      if (A[i] != 1) {
        break;
      }
      maxPrefix++;
    }

    int checkIdx = N - 1;

    for (int q : queries) {
      switch (q) {
      case 1:
        if (A[checkIdx--] == 1) {
          maxPrefix++;
        } else {
          maxPrefix = 0;
        }

        if (checkIdx == -1) {
          checkIdx = N - 1;
        }
        break;

      case 2:
        res[idx++] = maxPrefix;
        break;
      }
    }

    return res;
  }
}