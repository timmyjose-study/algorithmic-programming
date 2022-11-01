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

struct CompFreq {
  unordered_map<int, int> m;

  CompFreq(const unordered_map<int, int> &m) : m(m) {}

  bool operator()(int x, int y) { return m[x] > m[y]; }
};

// O(n + nlogk) / O(n)
vector<int> top_k_frequent(const vector<int> &a, int k) {
  unordered_map<int, int> freq;
  for (int e : a) {
    if (freq.find(e) == freq.end()) {
      freq[e] = 1;
    } else {
      freq[e]++;
    }
  }

  CompFreq comp(freq);
  priority_queue<int, vector<int>, CompFreq> min_heap(comp);

  for (int i = 0; i < k; i++) {
    min_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (!min_heap.empty() && freq[a[i]] > freq[min_heap.top()]) {
      min_heap.pop();
      min_heap.push(a[i]);
    }
  }

  vector<int> res;
  while (!min_heap.empty()) {
    res.push_back(min_heap.top());
    min_heap.pop();
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = top_k_frequent(a, k);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}