#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class DSUF {
private:
  vector<int> rank;
  vector<int> parent;

public:
  DSUF(int sz) {
    for (int i = 0; i < sz; i++) {
      this->rank.push_back(0);
      this->parent.push_back(i);
    }
  }

  int dsuf_find(int p) {
    if (p != this->parent[p]) {
      p = dsuf_find(this->parent[p]);
    }

    return this->parent[p];
  }

  void dsuf_union(int p, int q) {
    int pid = dsuf_find(p);
    int qid = dsuf_find(q);

    if (pid == qid) {
      return;
    }

    if (this->rank[pid] > this->rank[qid]) {
      this->parent[qid] = pid;
    } else {
      this->parent[pid] = qid;
      if (this->rank[pid] == this->rank[qid]) {
        this->rank[qid]++;
      }
    }
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to, nq;
  cin >> n >> m;

  DSUF dsuf(n);
  for (int i = 0; i < m; i++) {
    cin >> from >> to;
    dsuf.dsuf_union(from, to);
  }

  cin >> nq;
  while (nq--) {
    cin >> from >> to;
    cout << (dsuf.dsuf_find(from) == dsuf.dsuf_find(to) ? "yes" : "no") << "\n";
  }

  return 0;
}