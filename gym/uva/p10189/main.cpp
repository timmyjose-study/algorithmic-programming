#include <algorithm>
#include <array>
#include <bitset>
#include <cassert>
#include <cctype>
#include <chrono>
#include <cmath>
#include <cstddef>
#include <cstdint>
#include <cstdlib>
#include <deque>
#include <functional>
#include <iostream>
#include <limits>
#include <list>
#include <map>
#include <numeric>
#include <queue>
#include <random>
#include <regex>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

const int N = 110;
const int M = 110;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  char a[N][M];

  int idx = 0;
  while (true) {
    cin >> n >> m;

    if (!n && !m) {
      break;
    }

    idx++;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> a[i][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '.') {
          int cnt = 0;

          if (i > 0 && a[i - 1][j] == '*') {
            cnt++;
          }

          if (i < n - 1 && a[i + 1][j] == '*') {
            cnt++;
          }

          if (j > 0 && a[i][j - 1] == '*') {
            cnt++;
          }

          if (j < m - 1 && a[i][j + 1] == '*') {
            cnt++;
          }

          if (i > 0 && j > 0 && a[i - 1][j - 1] == '*') {
            cnt++;
          }

          if (i > 0 && j < m - 1 && a[i - 1][j + 1] == '*') {
            cnt++;
          }

          if (i < n - 1 && j < m - 1 && a[i + 1][j + 1] == '*') {
            cnt++;
          }

          if (i < n - 1 && j > 0 && a[i + 1][j - 1] == '*') {
            cnt++;
          }

          a[i][j] = cnt + '0';
        }
      }
    }

    if (idx > 1) {
      cout << "\n";
    }

    cout << "Field #" << idx << ":\n";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cout << a[i][j];
      }
      cout << "\n";
    }
  }

  return 0;
}