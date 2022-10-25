#include <algorithm>
#include <iostream>
#include <list>
#include <vector>

using namespace std;

// O(n3) / O(n)
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

    sort(a.begin(), a.end());

    vector<vector<int>> res;
    for (int i = 0; i < n - 2; i++) {
      int left = i + 1, right = n - 1;

      while (left < right) {
        int sum = a[i] + a[left] + a[right];

        if (sum < s) {
          for (int j = right; j > left; j--) {
            vector<int> v;
            v.push_back(a[i]);
            v.push_back(a[left]);
            v.push_back(a[j]);

            res.emplace_back(v);
          }
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