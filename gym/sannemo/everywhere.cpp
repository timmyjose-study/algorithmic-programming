#include <array>
#include <iostream>
#include <string>

using namespace std;

const int N = 110;

int main() {
  int tt, n;
  array<string, N> a;

  auto Present = [](auto &a, string &s) {
    for (int i = 0; i < a.size(); i++) {
      if (a[i] == s) {
        return true;
      }
    }

    return false;
  };

  cin >> tt;

  string city;
  while (tt--) {
    cin >> n;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      cin >> city;
      if (!Present(a, city)) {
        a[cnt++] = city;
      }
    }

    cout << cnt << "\n";
  }

  return 0;
}