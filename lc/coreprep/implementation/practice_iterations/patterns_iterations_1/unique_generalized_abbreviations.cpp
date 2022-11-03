#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

vector<string> subsets(const string &s) {
  vector<string> res;
  res.push_back("");

  for (char c : s) {
    int sz = res.size();
    for (int j = 0; j < sz; j++) {
      string curr = res[j];
      curr += c;
      res.push_back(curr);
    }
  }

  return res;
}

string compress(const string &s) {
  string t = "";
  int c = 0;
  int i = 0;
  while (i < s.size()) {
    if (s[i] == '1') {
      c++;
    } else {
      if (c != 0) {
        t += to_string(c);
      }
      c = 0;
      t += s[i];
    }
    i++;
  }

  if (c != 0) {
    t += to_string(c);
  }

  return t;
}

vector<string> process_subs(vector<string> &subs, const string &s) {
  vector<string> processed;

  for (auto t : subs) {
    if (t.empty()) {
      string p = "";
      for (int i = 0; i < s.size(); i++) {
        p += "1";
      }

      processed.push_back(compress(p));
    } else {
      string p = "";

      int i = 0, j = 0;
      while (i < s.size()) {
        if (s[i] == t[j]) {
          p += s[i];
          j++;
        } else {
          p += "1";
        }
        i++;
      }

      processed.push_back(compress(p));
    }
  }

  return processed;
}

// O(n x 2n) / O(n x 2n)
vector<string> unique_generalized_abbreviaions(const string &s) {
  vector<string> subs = subsets(s);
  return process_subs(subs, s);
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

    auto res = unique_generalized_abbreviaions(s);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}