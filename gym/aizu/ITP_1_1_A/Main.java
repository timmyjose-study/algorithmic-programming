import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Solution sol = new Solution();
      sol.solve();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}

class Solution {
  public void solve() { System.out.println("Hello World"); }
}

class Scanner implements AutoCloseable {
  private BufferedReader reader;

  public Scanner(InputStream in) {
    this.reader = new BufferedReader(new InputStreamReader(in));
  }

  public int nextInt() { return Integer.parseInt(readLine().trim()); }
  public long nextLong() { return Long.parseLong(readLine().trim()); }
  public double nextDouble() { return Double.parseDouble(readLine().trim()); }
  public String nextLine() { return readLine(); }

  public int[] nextIntArray() {
    String[] sa = this.readLine().trim().split("[ \t]");
    int[] a = new int[sa.length];
    for (int i = 0; i < sa.length; i++) {
      a[i] = Integer.parseInt(sa[i]);
    }

    return a;
  }

  public long[] nextLongArray() {
    String[] sa = this.readLine().trim().split("[ \t]");
    long[] a = new long[sa.length];
    for (int i = 0; i < sa.length; i++) {
      a[i] = Long.parseLong(sa[i]);
    }

    return a;
  }

  public double[] nextDoubleArray() {
    String[] sa = this.readLine().trim().split("[ \t]");
    double[] a = new double[sa.length];
    for (int i = 0; i < sa.length; i++) {
      a[i] = Double.parseDouble(sa[i]);
    }

    return a;
  }

  private String readLine() {
    try {
      return this.reader.readLine();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void close() {
    try {
      this.reader.close();
    } catch (Throwable err) {
    }
  }
}