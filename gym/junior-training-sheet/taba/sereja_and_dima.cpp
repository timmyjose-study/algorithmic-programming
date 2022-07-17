#include <iostream>
#include <vector>

int main() {
  int n, e;
  std::vector<int> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> e;
    v.push_back(e);
  }

  int s = 0, d = 0, l = 0, r = v.size() - 1;
  bool sturn = true;
  while (l <= r) {
    if (v[l] >= v[r]) {
      if (sturn) {
        s += v[l];
        sturn = false;
      } else {
        d += v[l];
        sturn = true;
      }
      l++;
    } else {
      if (sturn) {
        s += v[r];
        sturn = false;
      } else {
        d += v[r];
        sturn = true;
      }
      r--;
    }
  }

  std::cout << s << " " << d << std::endl;

  return 0;
}