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

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int tt, n, k;

  cin >> tt;
  while (tt--) {
    cin >> n >> k;

    vector<int> a;
    int d;
    bool valid = true;
    for (int i = 0; i < 2 * n; i++) {
      cin >> d;
      a.push_back(d);
    }

    sort(a.begin(), a.end());

    for (int i = 0; i < n; i++) {
      if ((a[i + n] - a[i]) < k) {
        valid = false;
        break;
      }
    }

    cout << (valid ? "YES" : "NO") << "\n";
  }

  return 0;
}