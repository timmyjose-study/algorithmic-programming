#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class graph {
private:
  vector<vector<int>> adj;
  int sz;

public:
  graph(int sz) : sz(sz) {
    for (int i = 0; i < sz; i++) {
      vector<int> v;
      for (int j = 0; j < sz; j++) {
        v.push_back(0);
      }
      this->adj.emplace_back(v);
    }
  }

  void add_edge(int from, int to) {
    if (from < 0 || from >= this->sz || to < 0 || to >= this->sz) {
      throw "invalid vertex";
    }

    this->adj[from][to] = 1;
  }

  int size() const { return this->sz; }

  const vector<int> get_adjacent_vertices(int v) const {
    if (v < 0 || v >= this->sz) {
      throw "invalid vertex";
    }

    vector<int> neighbours;
    for (int i = 0; i < this->sz; i++) {
      if (this->adj[v][i] == 1) {
        neighbours.push_back(i);
      }
    }

    return neighbours;
  }
};

void dfs_pre(const graph &g, vector<bool> &visited, int curr_vertex) {
  visited[curr_vertex] = true;
  cout << curr_vertex << " ";

  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      dfs_pre(g, visited, neighbour);
    }
  }
}

void dfs_pre(const graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs_pre(g, visited, i);
    }
  }
  cout << "\n";
}

void dfs_pre_iter(graph &g, vector<bool> &visited, int curr_vertex) {
  vector<int> st;
  st.push_back(curr_vertex);

  while (!st.empty()) {
    int v = st.back();
    st.pop_back();

    visited[v] = true;
    cout << v << " ";

    for (int neighbour : g.get_adjacent_vertices(v)) {
      if (!visited[neighbour]) {
        st.push_back(neighbour);
      }
    }
  }
}

void dfs_pre_iter(graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs_pre_iter(g, visited, i);
    }
  }
  cout << "\n";
}

void dfs_post(graph const &g, vector<bool> &visited, int curr_vertex) {
  visited[curr_vertex] = true;
  for (int neighbour : g.get_adjacent_vertices(curr_vertex)) {
    if (!visited[neighbour]) {
      dfs_post(g, visited, neighbour);
    }
  }

  cout << curr_vertex << " ";
}

void dfs_post(graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs_post(g, visited, i);
    }
  }
  cout << "\n";
}

void dfs_post_iter(graph &g, vector<bool> &visited, int curr_vertex) {
  vector<int> st;
  vector<int> rev_st;

  st.push_back(curr_vertex);
  while (!st.empty()) {
    int v = st.back();
    st.pop_back();
    rev_st.push_back(v);

    visited[v] = true;
    for (int neighbour : g.get_adjacent_vertices(v)) {
      if (!visited[neighbour]) {
        st.push_back(neighbour);
      }
    }
  }

  while (!rev_st.empty()) {
    cout << (rev_st.back()) << " ";
    rev_st.pop_back();
  }
}

void dfs_post_iter(graph &g) {
  vector<bool> visited(g.size());
  fill(visited.begin(), visited.end(), false);

  for (int i = 0; i < g.size(); i++) {
    if (!visited[i]) {
      dfs_post_iter(g, visited, i);
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

  dfs_pre(g);
  dfs_pre_iter(g);
  dfs_post(g);
  dfs_post_iter(g);

  return 0;
}