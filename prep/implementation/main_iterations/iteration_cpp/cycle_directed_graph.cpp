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

bool dfs(Graph &g, vector<bool> &visited, int curr_vertex,
         vector<bool> &call_st) {
  if (call_st[curr_vertex]) {
    return true;
  }

  visited[curr_vertex] = true;
  call_st[curr_vertex] = true;

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (dfs(g, visited, neighbour, call_st)) {
      return true;
    }
  }

  call_st[curr_vertex] = false;
  return false;
}

bool check_cycle(Graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      vector<bool> call_st;
      call_st.push_back(i);
      if (dfs(g, visited, i, call_st)) {
        return true;
      }
    }
  }
  return false;
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

  cout << (check_cycle(g) ? "true" : "false") << "\n";

  return 0;
}