#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

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

    sort(a.begin(), a.end());

    vector<vector<int>> res;

    for (int i = 0; i < n - 2; i++) {
      int left = i + 1, right = n - 1, target_sum = -a[i];

      while (left < right) {
        int sum = a[left] + a[right];
        if (sum == target_sum) {
          vector<int> triplet;
          triplet.push_back(a[i]);
          triplet.push_back(a[left]);
          triplet.push_back(a[right]);

          res.emplace_back(triplet);
          left++;
          right--;
        } else if (sum < target_sum) {
          left++;
        } else {
          right--;
        }
      }
    }

    for (auto t : res) {
      for (int e : t) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}