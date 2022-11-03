#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

struct CompDistinct {
  bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) {
    return p1.second > p2.second;
  }
};

// O(nlogn) / O(n)
int maximum_distinct_elements(const vector<int> &a, int k) {
  unordered_map<int, int> freq;
  for (int e : a) {
    if (freq.find(e) == freq.end()) {
      freq[e] = 1;
    } else {
      freq[e]++;
    }
  }

  int cnt = 0;
  priority_queue<pair<int, int>, vector<pair<int, int>>, CompDistinct> min_heap;
  for (auto entry : freq) {
    if (entry.second > 1) {
      min_heap.push(make_pair<>(entry.first, entry.second));
    } else {
      cnt++;
    }
  }

  while (k > 0 && !min_heap.empty()) {
    auto p = min_heap.top();
    min_heap.pop();

    if (p.second - 1 <= k) {
      cnt++;
      k -= p.second - 1;
    } else {
      p.second--;
      k--;
      min_heap.push(p);
    }
  }

  if (k > 0) {
    cnt -= k;
  }

  return cnt;
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