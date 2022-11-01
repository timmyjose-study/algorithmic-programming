#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

// O(n3) / O(1)
vector<tuple<int, int, int>> find_triplets_smaller(vector<int> &a, int s) {
  sort(a.begin(), a.end());

  int n = a.size();
  vector<tuple<int, int, int>> res;
  for (int i = 0; i < n - 2; i++) {
    int left = i + 1, right = n - 1;

    while (left < right) {
      if (a[i] + a[left] + a[right] < s) {
        for (int j = right; j > left; j--) {
          res.push_back(make_tuple<>(a[i], a[left], a[j]));
        }
        left++;
      } else {
        right--;
      }
    }
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = find_triplets_smaller(a, s);
    for (auto r : res) {
      cout << get<0>(r) << " " << get<1>(r) << " " << get<2>(r) << " \n";
    }
  }

  return 0;
}