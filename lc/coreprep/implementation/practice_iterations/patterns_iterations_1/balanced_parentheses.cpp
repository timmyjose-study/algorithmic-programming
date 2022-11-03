#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

struct ParenState {
  string s;
  int nl;
  int nr;

  ParenState(string s, int nl, int nr) : s(s), nl(nl), nr(nr) {}
};

// O(n x 2n) / O(n x 2n)
vector<string> balanced_parentheses(int n) {
  queue<ParenState> q;
  q.push(ParenState("(", 1, 0));

  vector<string> res;
  while (!q.empty()) {
    int new_states = 0;
    auto state = q.front();
    q.pop();

    if (state.nl < n) {
      auto left_state = state;
      left_state.s += "(";
      left_state.nl++;

      q.push(left_state);
      new_states++;
    }

    if (state.nr < state.nl) {
      auto right_state = state;
      right_state.s += ")";
      right_state.nr++;
      q.push(right_state);
      new_states++;
    }

    if (new_states == 0) {
      res.push_back(state.s);
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    auto res = balanced_parentheses(n);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}