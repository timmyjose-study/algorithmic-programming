#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int n;
  std::string s;

  std::cin >> n >> s;

  for (char c : s) {
    if (c != '4' && c != '7') {
      std::cout << "NO" << std::endl;
      return 0;
    }
  }

  int ls = 0, rs = 0;
  for (int i = 0; i < n / 2; i++) {
    ls += s[i] - '0';
  }

  for (int j = n / 2; j < n; j++) {
    rs += s[j] - '0';
  }

  std::cout << ((ls == rs) ? "YES" : "NO") << std::endl;

  return 0;
}