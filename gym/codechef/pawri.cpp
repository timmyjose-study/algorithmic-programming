#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;

    auto len = s.size();
    if (len < 5) {
      cout << s << "\n";
      continue;
    }

    for (int i = 0; i < len - 4; i++) {
      if (s.substr(i, 5) == "party") {
        s.replace(i, 5, "pawri");
      }
    }

    cout << s << "\n";
  }

  return 0;
}