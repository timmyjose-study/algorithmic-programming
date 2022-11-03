#include <algorithm>
#include <cctype>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

// O(n x 2n) / O(n x 2n)
vector<string> permute_case(const string &s) {
  queue<string> q;
  q.push("");

  vector<string> res;
  for (char c : s) {
    int sz = q.size();

    for (int i = 0; i < sz; i++) {
      string p1 = q.front();
      string p2 = p1;
      q.pop();

      if (!isalpha(c)) {
        p1 += c;

        if (p1.size() == s.size()) {
          res.push_back(p1);
        } else {
          q.push(p1);
        }
      } else {
        p1 += c;
        if (isupper(c)) {
          p2 += tolower(c);
        } else {
          p2 += toupper(c);
        }

        if (p1.size() == s.size()) {
          res.push_back(p1);
          res.push_back(p2);
        } else {
          q.push(p1);
          q.push(p2);
        }
      }
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    cin >> s;

    auto res = permute_case(s);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}