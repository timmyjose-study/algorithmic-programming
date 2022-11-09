#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

struct CompareFreq {
  unordered_map<char, int> &freq;

  CompareFreq(unordered_map<char, int> &freq) : freq(freq) {}

  bool operator()(const char &c, const char &d) { return freq[c] < freq[d]; }
};

// O(nlogn) / O(n)
string sort(const string &s) {
  unordered_map<char, int> freq;
  for (char c : s) {
    if (freq.find(c) != freq.end()) {
      freq[c]++;
    } else {
      freq[c] = 1;
    }
  }

  CompareFreq comp(freq);
  priority_queue<char, vector<char>, CompareFreq> max_heap(comp);

  for (auto entry : freq) {
    max_heap.push(entry.first);
  }

  string res = "";
  while (!max_heap.empty()) {
    char c = max_heap.top();
    int f = freq[c];

    for (int i = 0; i < f; i++) {
      res += c;
    }
    max_heap.pop();
  }

  return res;
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
    cout << sort(s) << "\n";
  }

  return 0;
}