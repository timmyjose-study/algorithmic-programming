#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int count(const std::vector<int> &a, int d, bool less) {
  int low = 0, high = a.size() - 1;
  int mid = (low + high) / 2;

  while (low <= high) {
    mid = (low + high) / 2;
    if (a[mid] < d) {
      if (less) {
        return 1;
      } else {
        low = mid + 1;
      }
    } else if (a[mid] > d) {
      if (!less) {
        return 1;
      } else {
        high = mid - 1;
      }
    } else {
      if (less) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
  }

  return 0;
}

int main() {
  int n, d;
  std::vector<int> ns;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> d;
    ns.push_back(d);
  }

  std::sort(ns.begin(), ns.end());

  int sol = 0;
  for (int i = 1; i < n - 1; i++) {
    if (count(ns, ns[i], true) == 1 && count(ns, ns[i], false) == 1) {
      sol++;
    }
  }

  std::cout << sol << std::endl;

  return 0;
}