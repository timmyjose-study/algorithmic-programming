#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s, t;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> t;
    s += t;
  }

  int g = 1;
  char curr = s[0];

  for (int i = 1; i < s.size(); i++) {
    if (s[i] == curr) {
      g++;
    } else {
      curr = s[i];
    }
  }

  cout << g << "\n";

  return 0;
}