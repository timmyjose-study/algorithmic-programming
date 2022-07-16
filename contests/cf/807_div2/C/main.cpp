// MLE
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

  int tt, n, oo, qq;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n >> oo >> qq;
    cin >> s;

    int f, t;
    for (int i = 0; i < oo; i++) {
      cin >> f >> t;
      s += s.substr(f - 1, t - f + 1);
    }

    int d;
    for (int i = 0; i < qq; i++) {
      cin >> d;
      cout << s[d - 1] << "\n";
    }
  }

  return 0;
}