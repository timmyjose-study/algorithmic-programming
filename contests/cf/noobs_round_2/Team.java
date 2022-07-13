import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
  public static void main(String[] args) {
    try (BufferedReader in =
             new BufferedReader(new InputStreamReader(System.in))) {
      int tt = Integer.parseInt(in.readLine().trim());

      while (tt-- > 0) {
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> a = new ArrayList<>(n);
        s = in.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
          a.add(Integer.parseInt(s[i]));
        }

        Collections.sort(a, Collections.reverseOrder());

        int lp = 0, rp = a.size() - 1;
        int sol = 0;
        while (lp <= rp) {
          if (a.get(lp) >= k) {
            sol++;
            lp++;
          } else if ((lp != rp) && (a.get(lp) + a.get(rp)) >= k) {
            sol++;
            lp++;
            rp--;
          } else {
            rp--;
          }
        }

        System.out.printf("%d\n", sol);
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}