import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] nums = new int[n];

      for (int i = 0; i < n; i++) {
        nums[i] = in.nextInt();
      }

      List<List<Integer>> subsets = solve(nums);
      System.out.println(subsets);
    }
  }

  private static List<List<Integer>> solve(int[] nums) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    subsets(nums, 0, new ArrayList<>(), allSubsets);

    return allSubsets;
  }

  private static void subsets(int[] nums, int currIdx, List<Integer> currSubset,
                              List<List<Integer>> allSubsets) {
    if (currIdx == nums.length) {
      List<Integer> tmp = new ArrayList<>();
      for (Integer d : currSubset) {
        tmp.add(d);
      }

      allSubsets.add(tmp);
      return;
    }

    currSubset.add(nums[currIdx]);
    subsets(nums, currIdx + 1, currSubset, allSubsets);
    currSubset.remove(currSubset.size() - 1);
    subsets(nums, currIdx + 1, currSubset, allSubsets);
  }
}