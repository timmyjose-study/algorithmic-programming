#include <iostream>
#include <unordered_set>

int main() {
  int c;
  std::unordered_set<int> s;

  for (int i = 0; i < 4; i++) {
    std::cin >> c;
    s.insert(c);
  }

  std::cout << 4 - s.size() << std::endl;

  return 0;
}
