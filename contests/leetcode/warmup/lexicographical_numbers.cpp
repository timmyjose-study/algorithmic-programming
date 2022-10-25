class Solution {
public:
  void dfs(int c, int n, vector<int> &res) {
    if (c > n) {
      return;
    }

    res.push_back(c);
    for (int i = 0; i < 10; i++) {
      if (10 * c + i > n) {
        return;
      }
      dfs(10 * c + i, n, res);
    }
  }

  vector<int> lexicalOrder(int n) {
    vector<int> res;

    for (int i = 1; i < 10; i++) {
      dfs(i, n, res);
    }

    return res;
  }
};