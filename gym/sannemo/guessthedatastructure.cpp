// WA
#include <algorithm>
#include <iostream>
#include <queue>
#include <stack>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
  int n, op, elem;
  unordered_set<int> inp;
  queue<int> out;
  stack<int> st;
  queue<int> q;
  priority_queue<int> pq;

  while (cin >> n) {
    for (int i = 0; i < n; i++) {
      cin >> op >> elem;
      if (op == 1) {
        inp.insert(elem);
        st.push(elem);
        q.push(elem);
        pq.push(elem);
      } else {
        out.push(elem);
      }
    }

    int ss = 0, qs = 0, pqs = 0;
    bool valid = true;
    while (!out.empty()) {
      auto e = out.front();
      out.pop();

      if (inp.find(e) == inp.end()) {
        cout << "impossible\n";
        valid = false;
        break;
      }

      if (!st.empty()) {
        if (e == st.top()) {
          ss++;
        }
        st.pop();
      }

      if (!q.empty()) {
        if (e == q.front()) {
          qs++;
        }
        q.pop();
      }

      if (!pq.empty()) {
        if (e == pq.top()) {
          pqs++;
        }
        pq.pop();
      }
    }

    if (!valid) {
      continue;
    }

    // cout << "ss = " << ss << ", qs = " << qs << ", pqs = " << pqs << endl;

    if (qs > ss && qs > pqs) {
      cout << "queue\n";
    } else if (ss >= qs && ss > pqs) {
      cout << "stack\n";
    } else if (pqs > qs && pqs > ss) {
      cout << "priority queue\n";
    } else if (ss == pqs) {
      cout << "not sure\n";
    } else {
      cout << "impossible\n";
    }

    inp.clear();

    while (!st.empty()) {
      st.pop();
    }

    while (!q.empty()) {
      q.pop();
    }
    while (!pq.empty()) {
      pq.pop();
    }
  }

  return 0;
}