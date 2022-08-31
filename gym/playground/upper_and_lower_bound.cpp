#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n, q, d, elem;
  vector<int> v;

  cin >> n >> q;
  for (int i = 0; i < n; i++) {
    cin >> d;
    v.emplace_back(d);
  }

  sort(v.begin(), v.end());

  for (int i = 0; i < q; i++) {
    cin >> elem;

    cout << "Lower Bound for " << elem << " is "
         << (lower_bound(v.begin(), v.end(), elem) - v.begin()) << "\n";
    cout << "Upper Bound for " << elem << " is "
         << (upper_bound(v.begin(), v.end(), elem) - v.begin()) << "\n";
  }

  return 0;
}