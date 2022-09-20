#include <iostream>
#include <vector>

using namespace std;

class DSUF {
private:
  vector<int> rank;
  vector<int> parent;

public:
  DSUF(int n) {
    for (int i = 0; i < n; i++) {
      rank.push_back(0);
      parent.push_back(i);
    }
  }

  int dsuf_find(int p) {
    if (p != parent[p]) {
      p = dsuf_find(parent[p]);
    }

    return parent[p];
  }

  void dsuf_union(int p, int q) {
    int pid = dsuf_find(p);
    int qid = dsuf_find(q);

    if (pid == qid) {
      return;
    }

    if (rank[pid] > rank[qid]) {
      parent[qid] = pid;
    } else {
      parent[pid] = qid;
      if (rank[pid] == rank[qid]) {
        rank[qid]++;
      }
    }
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, op, from, to;
  cin >> n >> nq;

  DSUF dsuf(n);
  while (nq--) {
    cin >> op >> from >> to;

    if (op == 0) {
      dsuf.dsuf_union(from, to);
    } else {
      cout << (dsuf.dsuf_find(from) == dsuf.dsuf_find(to) ? 1 : 0) << "\n";
    }
  }

  return 0;
}