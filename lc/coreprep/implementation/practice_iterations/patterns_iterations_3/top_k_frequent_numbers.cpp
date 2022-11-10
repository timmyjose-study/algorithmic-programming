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
  unordered_map<int, int> &freq;

  FreqComp(unordered_map<int, int> &freq) : freq(freq) {}

  bool operator()(int x, int y) { return freq[x] > freq[y]; }
};

// O(n + nlogk) / O(n)
vector<int> top_k_frequent_numbers(const vector<int> &a, int k) {
  unordered_map<int, int> freq;

  for (int e : a) {
    if (freq.find(e) == freq.end()) {
      freq[e] = 1;
    } else {
      freq[e]++;
    }
  }

  FreqComp comp(freq);
  priority_queue<int, vector<int>, FreqComp> min_heap(comp);

  for (auto entry : freq) {
    if (min_heap.size() < k) {
      min_heap.push(entry.first);
    } else if (entry.second > freq[min_heap.top()]) {
      min_heap.pop();
      min_heap.push(entry.first);
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

    auto res = top_k_frequent_numbers(a, k);
    for (auto r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}