#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  string s;

  cin >> n >> m;
  cin.ignore(1, '\n');

  vector<vector<char>> a(n, vector<char>(m));
  for (int i = 0; i < n; i++) {
    cin >> s;
    for (int j = 0; j < m; j++) {
      a[i][j] = s[j];
    }
  }

  for (int i = 0; i < m; i++) {
    int bs = 0;
    for (int j = 0; j < n; j++) {
      if (a[j][i] == '#') {
        bs++;
      }
    }
    cout << bs << " ";
  }
  cout << "\n";

  return 0;
}