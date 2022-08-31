#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s.size() > 10) {
      cout << s[0] << (s.size() - 2) << s[s.size() - 1] << "\n";
    } else {
      cout << s << "\n";
    }
  }

  return 0;
}