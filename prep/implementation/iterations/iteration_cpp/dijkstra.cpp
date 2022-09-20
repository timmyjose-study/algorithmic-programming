#include <algorithm>
#include <iostream>
#include <limits>
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

struct Edge {
  int from;
  int to;

  Edge(int from, int to) {
    this->from = from;
    this->to = to;
  }

  bool operator==(const Edge &other) const {
    return (this->from == other.from) && (this->to == other.to);
  }

  struct HashFunction {
    size_t operator()(const Edge &e) const {
      size_t from_hash = hash<int>()(e.from);
      size_t to_hash = hash<int>()(e.to) << 1;

      return from_hash ^ to_hash;
    }
  };
};

struct DistanceInfo {
  int distance;
  int last_vertex;

  DistanceInfo() {
    this->distance = numeric_limits<int>::max();
    this->last_vertex = -1;
  }
};

struct Comparator {
  bool operator()(const pair<int, int> &p, const pair<int, int> &q) const {
    if (p.second < q.second) {
      return true;
    }
    return false;
  }
};

void dijkstra(Graph &g, int source,
              unordered_map<Edge, int, Edge::HashFunction> &weights) {
  vector<DistanceInfo> dist(g.size());
  dist[source].distance = 0;
  dist[source].last_vertex = source;

  priority_queue<pair<int, int>, vector<pair<int, int>>, Comparator> pq;
  pq.push(make_pair(source, 0));

  while (!pq.empty()) {
    auto p = pq.top();
    pq.pop();

    int from = p.first;

    for (int to : g.get_adjacent_vertices(from)) {
      Edge edge(from, to);

      if (dist[from].distance + weights.at(edge) < dist[to].distance) {
        dist[to].distance = dist[from].distance + weights.at(edge);
        dist[to].last_vertex = from;
        pq.push(make_pair(to, dist[to].distance));
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

  int n, m, source, from, to, weight;
  cin >> n >> m >> source;

  Graph g(n);
  unordered_map<Edge, int, Edge::HashFunction> weights;

  for (int i = 0; i < m; i++) {
    cin >> from >> to >> weight;
    g.add_edge(from, to);
    weights[Edge(from, to)] = weight;
  }

  dijkstra(g, source, weights);

  return 0;
}