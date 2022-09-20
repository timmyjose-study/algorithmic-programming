#include <iostream>
#include <queue>
#include <set>
#include <unordered_map>
#include <vector>

using namespace std;

struct Vertex {
  set<int> vs;

  void add_edge(int v) { this->vs.insert(v); }

  const vector<int> get_adjacent_vertices() const {
    vector<int> neighbours;

    for (int v : this->vs) {
      neighbours.push_back(v);
    }

    return neighbours;
  }

  bool has_edge(int v) { return this->vs.find(v) != this->vs.end(); }
};

class Graph {
private:
  int sz;
  vector<Vertex> vertices;

public:
  Graph(int sz) : sz(sz) {
    for (int i = 0; i < sz; i++) {
      Vertex v;
      this->vertices.emplace_back(v);
    }
  }

  void add_edge(int from, int to) {
    if (from < 0 || from >= this->sz || to < 0 || to >= this->sz) {
      throw "illegal vertex";
    }

    this->vertices[from].add_edge(to);
  }

  const vector<int> get_adjacent_vertices(int v) const {
    if (v < 0 || v >= this->sz) {
      throw "illegal vertex";
    }

    return this->vertices[v].get_adjacent_vertices();
  }

  int size() const { return this->sz; }

  int indegree(int v) {
    if (v < 0 || v >= this->sz) {
      throw "illegal vertex";
    }

    int indegree = 0;
    for (int i = 0; i < size(); i++) {
      if (this->vertices[i].has_edge(v)) {
        indegree++;
      }
    }

    return indegree;
  }
};

void topological_sort(Graph &g) {
  queue<int> q;

  unordered_map<int, int> indeg;

  for (int i = 0; i < g.size(); i++) {
    int d = g.indegree(i);
    indeg[i] = d;

    if (d == 0) {
      q.push(i);
    }
  }

  vector<int> ordering;

  while (!q.empty()) {
    int v = q.front();
    q.pop();

    ordering.push_back(v);

    for (int neighbour : g.get_adjacent_vertices(v)) {
      indeg[neighbour]--;

      if (indeg[neighbour] == 0) {
        q.push(neighbour);
      }
    }
  }

  if (ordering.size() != g.size()) {
    throw "cycle detected";
  }

  for (int v : ordering) {
    cout << v << " ";
  }
  cout << "\n";
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to;
  cin >> n >> m;

  Graph g(n);
  for (int i = 0; i < m; i++) {
    cin >> from >> to;
    g.add_edge(from, to);
  }

  topological_sort(g);

  return 0;
}