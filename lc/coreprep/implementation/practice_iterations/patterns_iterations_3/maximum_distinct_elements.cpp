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

  bool operator()(int p, int q) { return freq[p] < freq[q]; }
};

// O(nlogn + klogn) / O(k)
int maximum_distinct_elements(const vector<int> &a, int k) {
  unordered_map<int, int> freq;

  for (int e : a) {
    if (freq.find(e) == freq.end()) {
      freq[e] = 1;
    } else {
      freq[e]++;
    }
  }

  FreqComp comp(freq);
  priority_queue<int, vector<int>, FreqComp> max_heap(comp);

  int res = 0;
  for (auto entry : freq) {
    if (entry.second == 1) {
      res++;
    } else {
      max_heap.push(entry.first);
    }
  }

  while (k > 0 && !max_heap.empty()) {
    int e = max_heap.top();
    max_heap.pop();

    if (freq[e] - 1 <= k) {
      k -= freq[e] - 1;
      freq[e] -= freq[e] - 1;
      res++;
    }
  }

  if (k > 0) {
    res -= k;
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

    cout << maximum_distinct_elements(a, k) << "\n";
  }

  return 0;
}