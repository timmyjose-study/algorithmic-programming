#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto binary_search = [](const vector<int> &a, int k) {
    int low = 0, high = a.size() - 1;
    int mid;

    while (low <= high) {
      mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  };

  int n, nq, k;
  cin >> n >> nq;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.end());

  while (nq--) {
    cin >> k;
    cout << (binary_search(a, k) != -1 ? "found" : "not found") << "\n";
  }

  return 0;
}