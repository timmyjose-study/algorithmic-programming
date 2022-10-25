import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] nums = new int[n];

      for (int i = 0; i < n; i++) {
        nums[i] = in.nextInt();
      }

      List<List<Integer>> allPerms = solve(nums);
      for (List<Integer> perm : allPerms) {
        for (int p : perm) {
          System.out.printf("%d ", p);
        }
        System.out.println();
      }
    }
  }

  private static List<List<Integer>> solve(int[] nums) {
    List<List<Integer>> allPerms = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    permutations(nums, new ArrayList<>(), visited, allPerms);

    return allPerms;
  }

  private static void permutations(int[] nums, List<Integer> currPerm,
                                   Set<Integer> visited,
                                   List<List<Integer>> allPerms) {
    if (currPerm.size() == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (Integer d : currPerm) {
        temp.add(d);
      }
      allPerms.add(temp);
      return;
    } else {
      for (int e : nums) {
        if (!visited.contains(e)) {
          visited.add(e);
          currPerm.add(e);
          permutations(nums, currPerm, visited, allPerms);
          visited.remove(e);
          currPerm.remove(currPerm.size() - 1);
        }
      }
    }
  }
}