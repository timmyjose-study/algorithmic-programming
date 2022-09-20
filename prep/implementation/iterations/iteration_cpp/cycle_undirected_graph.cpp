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

bool dfs(Graph &g, vector<bool> &visited, int curr_vertex, int parent) {
  visited[curr_vertex] = true;

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      if (dfs(g, visited, neighbour, curr_vertex)) {
        return true;
      }
    } else if (neighbour != parent) {
      return true;
    }
  }
  return false;
}

bool check_cycle(Graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      if (dfs(g, visited, i, -1)) {
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
    g.add_edge(to, from);
  }

  cout << (check_cycle(g) ? "true" : "false") << "\n";

  return 0;
}