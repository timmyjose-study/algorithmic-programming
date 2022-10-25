#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  string s = to_string(n);

  if (n == 0) {
    cout << n << "\n";
  } else {
    bool digit_seen = false;
    while (n) {
      int d = n % 10;
      if (!digit_seen && d) {
        digit_seen = true;
      }

      if (!digit_seen) {
        if (d) {
          cout << d;
        }
      } else {
        cout << n % 10;
      }
      n /= 10;
    }
    cout << "\n";
  }

  bool valid = true;
  for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
    if (s[i] != s[j]) {
      valid = false;
      break;
    }
  }

  cout << (valid ? "YES" : "NO") << "\n";

  return 0;
}