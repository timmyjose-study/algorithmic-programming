#include <algorithm>
#include <cctype>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> case_permutation(string s) {
  vector<string> res;

  for (int i = 0; i < s.size(); i++) {
    if (isalpha(s[i])) {
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    cin >> s;

    auto res = case_permutation(s);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}