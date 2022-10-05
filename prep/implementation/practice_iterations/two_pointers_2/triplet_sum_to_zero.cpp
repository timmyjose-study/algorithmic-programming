#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n2) / O(n)
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
      int left = i + 1, right = n - 1;

      while (left < right) {
        int sum = a[i] + a[left] + a[right];

        if (sum == 0) {
          vector<int> v;

          v.push_back(a[i]);
          v.push_back(a[left]);
          v.push_back(a[right]);

          res.emplace_back(v);
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    for (auto comp : res) {
      for (int e : comp) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}