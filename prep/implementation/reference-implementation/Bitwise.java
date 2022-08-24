import java.util.*;

public class Bitwise {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
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
          m ^= (1 << pos);
          System.out.println(m);
        } break;

        case "checkbit": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          System.out.println(((m & (1 << pos)) != 0 ? 1 : 0));
        } break;

        case "invert": {
          int m = Integer.parseInt(cmd[1]);
          m = ~m;
          System.out.println(m);
        } break;

        case "twoscomplement": {
          int m = Integer.parseInt(cmd[1]);
          System.out.println((~m + 1));
        } break;

        case "striplastsetbit": {
          int m = Integer.parseInt(cmd[1]);
          m &= m - 1;
          System.out.println((m));

        } break;

        case "lowestsetbit": {
          int m = Integer.parseInt(cmd[1]);
          m = m & (~m + 1);
          System.out.println(m);
        } break;

        case "divide": {
          int m = Integer.parseInt(cmd[1]);
          int powOfTwo = Integer.parseInt(cmd[2]);
          int k = (int)Math.round(Math.log(powOfTwo) / Math.log(2));
          System.out.println((m >> k));
        } break;

        case "multiply": {
          int m = Integer.parseInt(cmd[1]);
          int powOfTwo = Integer.parseInt(cmd[2]);
          int k = (int)Math.round(Math.log(powOfTwo) / Math.log(2));
          System.out.println((m << k));

        } break;

        case "clearbitsfromlsbtopos": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          m &= ~((1 << (pos + 1)) - 1);
          System.out.println(m);

        } break;

          // pos counted from LSB
        case "clearbitsfrommsbtopos": {
          int m = Integer.parseInt(cmd[1]);
          int pos = Integer.parseInt(cmd[2]);
          m &= ((1 << pos) - 1);
          System.out.println(m);
        } break;

        case "countsetbits": {
          int m = Integer.parseInt(cmd[1]);
          int count = 0;
          while (m != 0) {
            count += m & 1;
            m >>= 1;
          }
          System.out.println(count);
        } break;

        case "log2": {
          int m = Integer.parseInt(cmd[1]);
          int log = 0;
          while ((m >>= 1) != 0) {
            log++;
          }
          System.out.println(log);
        } break;

        case "checkpowerof2": {
          int m = Integer.parseInt(cmd[1]);
          System.out.println((m & (m - 1)) == 0 ? 1 : 0);
        } break;

        default:
          throw new IllegalStateException("invalid command");
        }
      }
    }
  }
}