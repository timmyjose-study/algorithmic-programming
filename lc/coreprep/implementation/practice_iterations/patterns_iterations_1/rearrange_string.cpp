#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

struct Entry {
  char c;
  int f;

  Entry(char c, int f) : c(c), f(f) {}
};

struct CompMax {
  bool operator()(const Entry *e1, const Entry *e2) { return e1->f < e2->f; }
};

// O(nlogn) / O(n)
string rearrange_string(const string &s) {
  unordered_map<char, int> freq;
  for (char c : s) {
    if (freq.find(c) == freq.end()) {
      freq[c] = 1;
    } else {
      freq[c]++;
    }
  }

  priority_queue<Entry *, vector<Entry *>, CompMax> max_heap;
  for (auto entry : freq) {
    max_heap.push(new Entry(entry.first, entry.second));
  }

  string res = "";
  Entry *prev = nullptr;

  while (!max_heap.empty()) {
    auto entry = max_heap.top();
    max_heap.pop();

    if (prev && prev->f > 0) {
      max_heap.push(prev);
    }

    entry->f -= 1;
    res += entry->c;
    prev = entry;
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
    cout << rearrange_string(s) << "\n";
  }

  return 0;
}