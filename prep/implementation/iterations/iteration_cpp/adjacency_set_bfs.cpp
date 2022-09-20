#include <algorithm>
#include <iostream>
#include <queue>
#include <set>
#include <vector>

using namespace std;

struct vertex {
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

class graph {
private:
  vector<vertex> vertices;
  int sz;

public:
  graph(int sz) : sz(sz) {
    for (int i = 0; i < sz; i++) {
      vertex v;
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

void bfs(graph &g, vector<bool> &visited, int curr_vertex) {
  queue<int> q;
  q.push(curr_vertex);

  while (!q.empty()) {
    int v = q.front();
    q.pop();

    visited[v] = true;
    cout << v << " ";

    for (int neighbour : g.get_adjacent_vertices(v)) {
      if (!visited[neighbour]) {
        q.push(neighbour);
      }
    }
  }
}

void bfs(graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      bfs(g, visited, i);
    }
  }
  cout << "\n";
}

void bfs_rec(graph &g, vector<bool> &visited, queue<int> &q) {
  if (q.empty()) {
    return;
  }

  int v = q.front();
  q.pop();

  visited[v] = true;
  cout << v << " ";

  for (int neighbour : g.get_adjacent_vertices(v)) {
    if (!visited[neighbour]) {
      q.push(neighbour);
    }
  }

  bfs_rec(g, visited, q);
}

void bfs_rec(graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      queue<int> q;
      q.push(i);
      bfs_rec(g, visited, q);
    }
  }
  cout << "\n";
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to;
  cin >> n >> m;

  graph g(n);
  for (int i = 0; i < m; i++) {
    cin >> from >> to;
    g.add_edge(from, to);
    g.add_edge(to, from);
  }

  bfs(g);
  bfs_rec(g);

  return 0;
}