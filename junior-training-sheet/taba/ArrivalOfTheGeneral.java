import java.util.Arrays;
import java.util.Scanner;

public class ArrivalOfTheGeneral {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      int swaps = 0;
      int maxPos = -1;
      int max = Arrays.stream(a).max().getAsInt();

      for (int i = 0; i < n; i++) {
        if (a[i] == max) {
          maxPos = i;
          break;
        }
      }

      for (int i = maxPos; i > 0; i--) {
        int t = a[i];
        a[i] = a[i-1];
        a[i-1] = t;
        swaps++;
      }

      int minPos = -1;
      int min = Arrays.stream(a).min().getAsInt();
      for (int i = n- 1; i >= 0; i--) {
        if (a[i] == min) {
          minPos = i;
          break;
        }
      }

      for (int i = minPos; i < n - 1; i++) {
        int t = a[i];
        a[i] = a[i+1];
        a[i+1] = t;
        swaps++;
      }

      System.out.println(swaps);
    }
  }
}