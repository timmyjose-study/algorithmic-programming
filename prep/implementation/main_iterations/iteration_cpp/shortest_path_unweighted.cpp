#include <algorithm>
#include <iostream>
#include <queue>
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

struct DistanceInfo {
  int distance;
  int last_vertex;

  DistanceInfo() {
    this->distance = -1;
    this->last_vertex = -1;
  }
};

void shortest_path(Graph &g, int source) {
  vector<DistanceInfo> dist(g.size());
  dist[source].distance = 0;
  dist[source].last_vertex = source;

  queue<int> q;
  q.push(source);

  while (!q.empty()) {
    int v = q.front();
    q.pop();

    for (int neighbour : g.get_adjacent_vertices(v)) {
      if (dist[neighbour].distance == -1) {
        dist[neighbour].distance = 1 + dist[v].distance;
        dist[neighbour].last_vertex = v;
        q.push(neighbour);
      }
    }
  }

  for (int i = 0; i < g.size(); i++) {
    if (i == source) {
      continue;
    }

    int d = dist[i].distance;
    if (d == -1) {
      cout << "no path\n";
    } else {
      cout << d << "\n";
      vector<int> st;
      int last_vertex = i;

      while (last_vertex != source) {
        st.push_back(last_vertex);
        last_vertex = dist[last_vertex].last_vertex;
      }
      st.push_back(source);

      while (!st.empty()) {
        cout << st.back() << " ";
        st.pop_back();
      }
      cout << "\n";
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, from, to, source;
  cin >> n >> m >> source;

  Graph g(n);
  for (int i = 0; i < m; i++) {
    cin >> from >> to;
    g.add_edge(from, to);
    g.add_edge(to, from);
  }

  shortest_path(g, source);

  return 0;
}