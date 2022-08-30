import java.util.*;

public class SegmentTreeRangeMinimumQuery {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();
      int[] a = new int[n];
      int[] tree = new int[4 * n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }
      in.nextLine();

      build(tree, 0, 0, n - 1, a);

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "u": {
          int idx = Integer.parseInt(cmd[1]) - 1;
          int val = Integer.parseInt(cmd[2]);
          update(tree, 0, 0, n - 1, idx, val, a);
        } break;

        case "q": {
          int l = Integer.parseInt(cmd[1]) - 1;
          int r = Integer.parseInt(cmd[2]) - 1;

          System.out.println(query(tree, 0, 0, n - 1, l, r));
        } break;
        }
      }
    }
  }
}
