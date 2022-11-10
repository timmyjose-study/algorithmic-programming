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

struct MaxComp {
  unordered_map<char, int> &freq;

  MaxComp(unordered_map<char, int> &freq) : freq(freq) {}

  bool operator()(char p, char q) { return freq[p] < freq[q]; }
};

// O(nlogn) / O(1)
string rearrange(const string &s) {
  unordered_map<char, int> freq;
  for (char c : s) {
    if (freq.find(c) == freq.end()) {
      freq[c] = 1;
    } else {
      freq[c]++;
    }
  }

  MaxComp comp(freq);
  priority_queue<char, vector<char>, MaxComp> max_heap(comp);

  for (auto entry : freq) {
    max_heap.push(entry.first);
  }

  string res = "";
  char prev = '\0';

  while (!max_heap.empty()) {
    char curr = max_heap.top();
    max_heap.pop();

    res.push_back(curr);
    freq[curr]--;

    if (prev != '\0' && freq[prev] > 0) {
      max_heap.push(prev);
    }
    prev = curr;
  }

  return res.size() == s.size() ? res : "";
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
    cout << rearrange(s) << "\n";
  }

  return 0;
}