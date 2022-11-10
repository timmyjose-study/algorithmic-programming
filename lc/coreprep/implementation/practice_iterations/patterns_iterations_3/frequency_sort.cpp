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

struct FreqComp {
  unordered_map<char, int> freq;

  FreqComp(unordered_map<char, int> freq) : freq(freq) {}

  bool operator()(const char c, const char d) { return freq[c] < freq[d]; }
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

  FreqComp comp(freq);
  priority_queue<char, vector<char>, FreqComp> max_heap(comp);

  for (auto entry : freq) {
    max_heap.push(entry.first);
  }

  string res = "";
  while (!max_heap.empty()) {
    char c = max_heap.top();
    max_heap.pop();

    int f = freq[c];
    while (f--) {
      res.push_back(c);
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
    cout << sort(s) << "\n";
  }

  return 0;
}