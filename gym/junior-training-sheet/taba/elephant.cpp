#include <array>
#include <iostream>

using namespace std;

int main() {
  int n, cnt = 0;
  array<int, 5> a{5, 4, 3, 2, 1};

  cin >> n;
  while (n) {
    for (auto &e : a) {
      if (n >= e) {
        cnt += n / e;
        n %= e;
      }
    }
  }

  cout << cnt << "\n";

  return 0;
}