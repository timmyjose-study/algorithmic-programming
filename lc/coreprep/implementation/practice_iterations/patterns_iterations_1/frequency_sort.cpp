#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

struct CompSort {
  unordered_map<char, int> &m;

  CompSort(unordered_map<char, int> &m) : m(m) {}

  bool operator()(const char &c, const char &d) { return m[c] < m[d]; }
};

// O(nlogn) / O(n)
string sort(const string &s) {
  unordered_map<char, int> freq;
  for (char c : s) {
    if (freq.find(c) == freq.end()) {
      freq[c] = 1;
    } else {
      freq[c]++;
    }
  }

  CompSort comp(freq);
  priority_queue<char, vector<char>, CompSort> max_heap(comp);

  for (auto entry : freq) {
    max_heap.push(entry.first);
  }

  string res = "";
  while (!max_heap.empty()) {
    char c = max_heap.top();
    int f = freq[c];

    while (f--) {
      res += c;
    }
    max_heap.pop();
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
    cout << sort(s) << "\n";
  }

  return 0;
}