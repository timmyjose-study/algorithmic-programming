#include <algorithm>
#include <iostream>
#include <set>
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
};

void dfs(Graph &g, vector<bool> &visited, int curr_vertex, int cc_id, int v1,
         int &v1_id, int v2, int &v2_id) {
  if (visited[curr_vertex]) {
    return;
  }

  visited[curr_vertex] = true;

  if (curr_vertex == v1) {
    v1_id = cc_id;
  }

  if (curr_vertex == v2) {
    v2_id = cc_id;
  }

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      dfs(g, visited, neighbour, cc_id, v1, v1_id, v2, v2_id);
    }
  }
}

bool is_connected(Graph &g, int from, int to) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  int cc_id = 0;
  int from_id = -1, to_id = -1;
  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs(g, visited, i, cc_id, from, from_id, to, to_id);
    }
    cc_id++;
  }

  return from_id == to_id;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to, nq;
  cin >> n >> m;

  Graph g(n);
  for (int i = 0; i < m; i++) {
    cin >> from >> to;
    g.add_edge(from, to);
  }

  cin >> nq;
  while (nq--) {
    cin >> from >> to;
    cout << (is_connected(g, from, to) ? "yes" : "no") << "\n";
  }

  return 0;
}