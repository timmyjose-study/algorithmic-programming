#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s;

  cin >> n >> s;

  char curr = s[0];
  int sol = 0;
  for (int i = 1; i < s.size(); i++) {
    if (s[i] == curr) {
      sol++;
    } else {
      curr = s[i];
    }
  }

  cout << sol << "\n";

  return 0;
}