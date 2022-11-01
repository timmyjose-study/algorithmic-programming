#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

// O(n2) / O(n)
vector<tuple<int, int, int>> find_triplets_sum_zero(vector<int> &a) {
  sort(a.begin(), a.end());

  int n = a.size();
  vector<tuple<int, int, int>> res;

  for (int i = 0; i < n - 2; i++) {
    int left = i + 1, right = n - 1;

    while (left < right) {
      int sum = a[i] + a[left] + a[right];

      if (sum == 0) {
        res.push_back(make_tuple<>(a[i], a[left], a[right]));
        left++;
        right--;
      } else if (sum < 0) {
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

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = find_triplets_sum_zero(a);
    for (auto r : res) {
      cout << get<0>(r) << " " << get<1>(r) << " " << get<2>(r) << " \n";
    }
  }

  return 0;
}