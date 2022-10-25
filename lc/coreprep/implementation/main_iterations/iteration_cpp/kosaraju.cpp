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

  Graph transpose() {
    Graph trans(this->sz);

    for (int i = 0; i < this->sz; i++) {
      for (int v : get_adjacent_vertices(i)) {
        trans.add_edge(v, i);
      }
    }

    return trans;
  }

  int size() const { return this->sz; }
};

void dfs1(Graph &g, vector<bool> &visited, int curr_vertex, vector<int> &st) {
  if (visited[curr_vertex]) {
    return;
  }

  visited[curr_vertex] = true;

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      dfs1(g, visited, neighbour, st);
    }
  }

  st.push_back(curr_vertex);
}

void dfs2(Graph &g, vector<bool> &visited, int curr_vertex, vector<int> &comp) {
  if (visited[curr_vertex]) {
    return;
  }

  visited[curr_vertex] = true;
  comp.push_back(curr_vertex);

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      dfs2(g, visited, neighbour, comp);
    }
  }
}

void kosaraju(Graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  vector<int> st(g.size());

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs1(g, visited, i, st);
    }
  }

  Graph trans = g.transpose();
  fill(visited.begin(), visited.end(), false);

  vector<vector<int>> scc;
  while (!st.empty()) {
    int v = st.back();
    st.pop_back();

    vector<int> comp;
    dfs2(trans, visited, v, comp);

    if (!comp.empty()) {
      scc.push_back(comp);
    }
  }

  cout << scc.size() << "\n";
  for (auto comp : scc) {
    for (auto c : comp) {
      cout << c << " ";
    }
    cout << "\n";
  }
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

  kosaraju(g);

  return 0;
}