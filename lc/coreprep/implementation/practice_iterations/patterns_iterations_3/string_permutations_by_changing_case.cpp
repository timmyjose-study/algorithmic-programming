#include <algorithm>
#include <cctype>
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

// O(nx2n) / O(nx2n)
vector<string> permutations_by_changing_case(const string &s) {
  vector<string> res;

  queue<string> q;
  q.push("");

  for (char c : s) {
    int size = q.size();

    for (int i = 0; i < size; i++) {
      string prev = q.front();
      q.pop();

      if (!isalpha(c)) {
        string curr = prev;
        curr.push_back(c);
        q.push(curr);
      } else {
        string curr1 = prev;
        curr1.push_back(tolower(c));
        q.push(curr1);

        string curr2 = prev;
        curr2.push_back(toupper(c));
        q.push(curr2);
      }
    }
  }

  while (!q.empty()) {
    res.push_back(q.front());
    q.pop();
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

    auto res = permutations_by_changing_case(s);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}