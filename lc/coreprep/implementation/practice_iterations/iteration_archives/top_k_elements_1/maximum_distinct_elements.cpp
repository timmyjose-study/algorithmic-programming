#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

struct PQEntry {
  int value;
  int freq;

  PQEntry(int value, int freq) : value(value), freq(freq) {}
};

struct CompareSmaller {
  bool operator()(const PQEntry &e1, PQEntry &e2) { return e1.freq > e2.freq; }
};

// O(nlogn + klogn) / O(n)
int max_distinct_elems(const vector<int> &a, int k) {
  unordered_map<int, int> freq;
  int res = 0;

  CompareSmaller comp;
  priority_queue<PQEntry, vector<PQEntry>, CompareSmaller> min_heap(comp);

  for (int e : a) {
    if (freq.find(e) != freq.end()) {
      freq[e]++;
    } else {
      freq[e] = 1;
    }
  }

  for (auto entry : freq) {
    if (entry.second > 1) {
      min_heap.push(PQEntry(entry.first, entry.second));
    } else {
      res++;
    }
  }

  while (k > 0 && !min_heap.empty()) {
    auto entry = min_heap.top();
    min_heap.pop();

    if (entry.freq - 1 <= k) {
      k -= entry.freq - 1;
      res++;
    } else {
      k--;
    }
  }

  if (k > 0) {
    res -= k;
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << max_distinct_elems(a, k) << "\n";
  }

  return 0;
}