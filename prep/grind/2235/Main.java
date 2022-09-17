import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Solution sol = new Solution();
      int n = in.nextInt();
      int m = in.nextInt();
      System.out.println(sol.solve(n, m));
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}

class Solution {
  public int solve(int n, int m) { return n + m; }
}