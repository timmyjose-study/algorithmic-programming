#include <algorithm>
#include <iomanip>
#include <iostream>
#include <queue>
#include <string>

using namespace std;

class MedianOfStream {
private:
  priority_queue<int> max_heap;
  priority_queue<int, vector<int>, greater<int>> min_heap;

  void rebalance() {
    if (max_heap.size() > min_heap.size() + 1) {
      min_heap.push(max_heap.top());
      max_heap.pop();
    } else if (max_heap.size() < min_heap.size()) {
      max_heap.push(min_heap.top());
      min_heap.pop();
    }
  }

public:
  MedianOfStream() {}

  // O(logn)
  void insert(int num) {
    if (max_heap.empty() || max_heap.top() >= num) {
      max_heap.push(num);
    } else {
      min_heap.push(num);
    }

    rebalance();
  }

  // O(1)
  double find_median() {
    if (max_heap.size() == min_heap.size()) {
      return (double)(max_heap.top() + min_heap.top()) / 2.0;
    }

    return max_heap.top();
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin.ignore(1, '\n');

    MedianOfStream mos;

    for (int i = 0; i < n; i++) {
      getline(cin, s);

      if (s == "findmedian") {
        cout << fixed << setprecision(1) << mos.find_median() << "\n";
      } else {
        int num = stoi(s.substr(7, s.end() - s.begin() + 7));
        mos.insert(num);
      }
    }
  }

  return 0;
}