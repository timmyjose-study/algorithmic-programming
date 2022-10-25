#include <iostream>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

int binary_search(const vector<int> &a, int low, int high, int elem) {
  int mid = -1;

  while (low <= high) {
    mid = low + (high - low) / 2;

    if (a[mid] < elem) {
      low = mid + 1;
    } else if (a[mid] > elem) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return -1;
}

int binary_search_rec(const vector<int> &a, int low, int high, int elem) {
  if (low > high) {
    return -1;
  }

  int mid = low + (high - low) / 2;
  if (a[mid] < elem) {
    return binary_search_rec(a, mid + 1, high, elem);
  } else if (a[mid] > elem) {
    return binary_search_rec(a, low, mid - 1, elem);
  }
  return mid;
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
    cout << binary_search(a, 0, n - 1, k) << "\n"
         << binary_search_rec(a, 0, n - 1, k) << "\n";
  }

  return 0;
}