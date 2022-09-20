#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class DSUF {
private:
  vector<int> rank;
  vector<int> parent;

  void make_set(int p) {
    this->rank.push_back(0);
    this->parent.push_back(p);
  }

public:
  DSUF(int sz) {
    for (int i = 0; i < sz; i++) {
      make_set(i);
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

struct Edge {
  int from;
  int to;
  int weight;

  Edge(int from, int to, int weight) {
    this->from = from;
    this->to = to;
    this->weight = weight;
  }
};

void kruskal(DSUF &dsuf, vector<Edge> &edges) {
  sort(edges.begin(), edges.end(),
       [](const auto &e1, const auto &e2) { return e1.weight < e2.weight; });

  vector<Edge> mst_edges;
  int mst_cost = 0;

  for (Edge edge : edges) {
    int from = edge.from;
    int to = edge.to;
    int weight = edge.weight;

    if (dsuf.dsuf_find(from) != dsuf.dsuf_find(to)) {
      dsuf.dsuf_union(from, to);
      mst_cost += weight;
      mst_edges.push_back(edge);
    }
  }

  cout << mst_cost << "\n";
  for (Edge edge : mst_edges) {
    cout << edge.from << " " << edge.to << "\n";
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to, weight;
  cin >> n >> m;

  DSUF dsuf(n);
  vector<Edge> edges;
  for (int i = 0; i < m; i++) {
    cin >> from >> to >> weight;
    edges.push_back(Edge(from, to, weight));
  }

  kruskal(dsuf, edges);

  return 0;
}