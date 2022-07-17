#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt;
  string s;

  auto IsLapin = [](const string &s) {
    auto len = s.size();
    auto left = s.substr(0, len / 2);
    auto right = len % 2 == 0 ? s.substr(len / 2, len / 2)
                              : s.substr(len / 2 + 1, len / 2);

    sort(left.begin(), left.end());
    sort(right.begin(), right.end());

    return left == right;
  };

  cin >> tt;
  while (tt--) {
    cin >> s;
    cout << (IsLapin(s) ? "YES" : "NO") << "\n";
  }

  return 0;
}