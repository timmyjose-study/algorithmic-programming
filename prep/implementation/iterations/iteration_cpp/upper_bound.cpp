#include <iostream>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

int upper_bound(const vector<int> &a, int low, int high, int elem) {
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

int upper_bound_rec(const vector<int> &a, int low, int high, int elem) {
  if (low >= high) {
    return a[low] > elem ? low : a.size();
  }

  int mid = low + (high - low) / 2;
  if (a[mid] <= elem) {
    return upper_bound_rec(a, mid + 1, high, elem);
  }
  return upper_bound_rec(a, low, mid, elem);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, k;
  cin >> n >> nq;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  display(a);
  sort(a.begin(), a.end());
  display(a);

  while (nq--) {
    cin >> k;
    cout << upper_bound(a, 0, n - 1, k) << "\n"
         << upper_bound_rec(a, 0, n - 1, k) << "\n";
  }

  return 0;
}