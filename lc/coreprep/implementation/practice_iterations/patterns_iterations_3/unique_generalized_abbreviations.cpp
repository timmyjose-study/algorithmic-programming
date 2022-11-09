#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

vector<string> subsets(const string &s) {
  vector<string> subs;
  subs.push_back("");

  for (char c : s) {
    int size = subs.size();

    for (int j = 0; j < size; j++) {
      string curr = subs[j];
      curr.push_back(c);
      subs.push_back(curr);
    }
  }

  return subs;
}

string process(const string &s) {
  string res = "";
  int i = 0;
  int cnt = 0;

  while (i < s.size()) {
    if (s[i] == '1') {
      cnt++;
    } else {
      if (cnt != 0) {
        res += to_string(cnt);
        cnt = 0;
      }
      res.push_back(s[i]);
    }
    i++;
  }

  if (cnt != 0) {
    res += to_string(cnt);
  }

  return res;
}

// O(n x 2n) / O(n x 2n)
vector<string> abbreviate(const string &s) {
  vector<string> subs = subsets(s);
  vector<string> processed;

  for (auto &sub : subs) {
    string proc = "";

    int j = 0;
    for (int i = 0; i < s.size(); i++) {
      if (j < sub.size() && (sub[j] == s[i])) {
        proc.push_back(s[i]);
        j++;
      } else {
        proc.push_back('1');
      }
    }

    processed.push_back(process(proc));
  }

  return processed;
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

    auto res = abbreviate(s);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}