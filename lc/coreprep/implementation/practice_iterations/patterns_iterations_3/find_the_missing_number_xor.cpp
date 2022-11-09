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
int find_missing_number(const vector<int> &a) {
  int xor1 = 0;
  for (int e : a) {
    xor1 ^= e;
  }

  int xor2 = 0;
  for (int i = 1; i <= a.size() + 1; i++) {
    xor2 ^= i;
  }

  return xor1 ^ xor2;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n - 1);
    for (int i = 0; i < n - 1; i++) {
      cin >> a[i];
    }

    cout << find_missing_number(a) << "\n";
  }

  return 0;
}