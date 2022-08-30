import java.util.*;

public class Bitwise {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "setbit": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          m |= 1 << pos;
          System.out.println(m);
        } break;

        case "clearbit": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          m &= ~(1 << pos);
          System.out.println(m);
        } break;

        case "togglebit": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          m ^= 1 << pos;
          System.out.println(m);

        } break;

        case "checkbit": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          System.out.println((m & (1 << pos)));
        } break;

        case "invert": {
          int m = Integer.parseInt(cmd[1]);
          m = ~m;
          System.out.println(m);
        } break;

        case "twoscomplement": {
          int m = Integer.parseInt(cmd[1]);
          m = ~m + 1;
          System.out.println(m);
        } break;

        case "striplastsetbit": {
          int m = Integer.parseInt(cmd[1]);
          m = m & ~1;
          System.out.println(m);
        } break;

        case "divide": {
          int m = Integer.parseInt(cmd[1]);
          int k = (int)Math.log(Integer.parseInt(cmd[2]) / Math.log(2));
          System.out.println((m >> k));
        } break;

        case "multiply": {
          int m = Integer.parseInt(cmd[1]);
          int k = (int)Math.log(Integer.parseInt(cmd[2]) / Math.log(2));
          System.out.println((m << k));

        } break;

        case "countsetbits": {
          int m = Integer.parseInt(cmd[1]);
          int c = 0;
          while (m > 0) {
            c += m & 1;
            m >>= 1;
          }
          System.out.println(c);
        } break;

        case "log2": {
          int m = Integer.parseInt(cmd[1]);
          int l = 0;
          while ((m >>= 1) != 0) {
            l++;
          }
          System.out.println(l);
        } break;

        case "checkpowerof2": {
          int m = Integer.parseInt(cmd[1]);
          System.out.println((m & (m - 1)) == 0 ? "1" : "0");
        } break;

        default:
          throw new IllegalArgumentException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}