class Solution {
  public int lengthLongestPath(String input) {
    Stack<Integer> levels = new Stack<>();
    String[] s = input.split("\n");
    int maxLen = 0, currLen = 0;

    for (String p : s) {
      int level = findLevel(p);

      while (levels.size() > level) {
        currLen -= levels.pop();
      }

      int len = p.replaceAll("\t", "").length() + 1;
      currLen += len;

      if (p.indexOf(".") != -1) {
        maxLen = Math.max(maxLen, currLen - 1);
      }
      levels.push(len);
    }
    return maxLen;
  }

  private static int findLevel(String s) {
    return s.length() - s.replaceAll("\t", "").length();
  }
}