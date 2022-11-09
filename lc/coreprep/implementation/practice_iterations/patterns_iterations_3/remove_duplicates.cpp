#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

// O(n) / O(1)
int remove_duplicate(vector<int> &a) {
  int next_pos = 1;

  for (int i = 1; i < a.size(); i++) {
    if (a[next_pos - 1] != a[i]) {
      a[next_pos++] = a[i];
    }
  }

  return next_pos;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int len = remove_duplicate(a);
    cout << len << "\n";
    for (int i = 0; i < len; i++) {
      cout << a[i] << " ";
    }
    cout << "\n";
  }

  return 0;
}