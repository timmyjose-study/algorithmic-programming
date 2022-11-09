#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

struct CompareFreq {
  unordered_map<int, int> &freq;

  CompareFreq(unordered_map<int, int> &freq) : freq(freq) {}

  bool operator()(int x, int y) {
    // max heap reverses the condition!
    return freq[x] > freq[y];
  }
};

// O(n + nlogk) / O(n)
vector<int> top_k_frequent_numbers(const vector<int> &a, int k) {
  unordered_map<int, int> freq;
  for (int e : a) {
    if (freq.find(e) != freq.end()) {
      freq[e]++;
    } else {
      freq[e] = 1;
    }
  }

  CompareFreq comp(freq);
  priority_queue<int, vector<int>, CompareFreq> min_heap(comp);

  for (auto entry : freq) {
    min_heap.push(entry.first);
    if (min_heap.size() > k) {
      min_heap.pop();
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

    auto res = top_k_frequent_numbers(a, k);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}