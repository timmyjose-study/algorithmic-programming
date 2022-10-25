#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s;

  cin >> n >> s;

  int score = 0;

  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'V') {
      score += 5;
    } else if (s[i] == 'W') {
      score += 2;
    } else if (s[i] == 'X') {
      i++;
    } else if (s[i] == 'Y' && i < s.size() - 1) {
      char c = s[i + 1];
      i++;
      s += c;
    } else if (s[i] == 'Z' && i < s.size() - 1) {
      if (s[i + 1] == 'V') {
        score /= 5;
        i++;
      } else if (s[i + 1] == 'W') {
        score /= 2;
        i++;
      }
    }
  }

  cout << score << "\n";

  return 0;
}