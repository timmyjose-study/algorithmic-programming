#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n2) / O(1)
int count_less_than_target(vector<int> &a, int s) {
  sort(a.begin(), a.end());

  int n = a.size(), cnt = 0;
  for (int i = 0; i < n - 2; i++) {
    int left = i + 1, right = n - 1;

    while (left < right) {
      int sum = a[i] + a[left] + a[right];
      if (sum < s) {
        cnt += right - left;
        left++;
      } else {
        right--;
      }
    }
  }

  return cnt;
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

    cout << count_less_than_target(a, s) << "\n";
  }

  return 0;
}