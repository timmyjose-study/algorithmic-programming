#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int lower_bound(const vector<int> &a, int elem) {
  int low = 0, high = a.size() - 1;
  int mid = -1;

  while (low < high) {
    mid = low + (high - low) / 2;

    if (a[mid] < elem) {
      low = mid + 1;
    } else {
      high = mid;
    }
  }

  return a[low] >= elem ? low : a.size();
}

int upper_bound(const vector<int> &a, int elem) {
  int low = 0, high = a.size() - 1;
  int mid = -1;

  while (low < high) {
    mid = low + (high - low) / 2;

    if (a[mid] <= elem) {
      low = mid + 1;
    } else {
      high = mid;
    }
  }

  return a[low] > elem ? low : a.size();
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.end());

  int sol = 0;
  for (int i = 1; i < a.size() - 1; i++) {
    int lb_idx = lower_bound(a, a[i]);
    if (lb_idx > 0 && a[lb_idx - 1] < a[i]) {
      int ub_idx = upper_bound(a, a[i]);
      if (ub_idx != a.size() && a[ub_idx] > a[i]) {
        sol++;
      }
    }
  }

  cout << sol << "\n";

  return 0;
}