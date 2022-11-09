#include <algorithm>
#include <iomanip>
#include <iostream>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class MedianOfStream {
private:
  priority_queue<int> max_heap;
  priority_queue<int, vector<int>, greater<int>> min_heap;

  void rebalance() {
    if (max_heap.size() > min_heap.size() + 1) {
      min_heap.push(max_heap.top());
      max_heap.pop();
    } else if (min_heap.size() > max_heap.size()) {
      max_heap.push(min_heap.top());
      min_heap.pop();
    }
  }

public:
  // O(logn) / O(n)
  void insert_num(int num) {
    if (max_heap.empty() || num < max_heap.top()) {
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
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin.ignore(1, '\n');

    MedianOfStream mos;

    while (n--) {
      getline(cin, s);

      stringstream ss(s);

      string cmd;
      getline(ss, cmd, ' ');

      if (cmd == "findmedian") {
        cout << fixed << setprecision(1) << mos.find_median() << "\n";
      } else {
        string val;
        getline(ss, val, ' ');

        mos.insert_num(stoi(val));
      }
    }
  }

  return 0;
}