#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

using Graph = unordered_map<int, unordered_set<int>>;
using Degree = unordered_map<int, int>;

// O(V + E) / O(V + E)
bool has_cycle(Graph &graph, Degree &indegree) {
  queue<int> q;
  for (auto entry : indegree) {
    if (entry.second == 0) {
      q.push(entry.first);
    }
  }

  vector<int> res;
  while (!q.empty()) {
    int v = q.front();
    q.pop();

    res.push_back(v);
    for (int neighbour : graph[v]) {
      indegree[neighbour]--;
      if (indegree[neighbour] == 0) {
        q.push(neighbour);
      }
    }
  }

  return res.size() != graph.size();
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, from, to;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;

    Graph graph;
    Degree indegree;
    for (int i = 0; i < n; i++) {
      graph[i] = unordered_set<int>{};
      indegree[i] = 0;
    }

    for (int i = 0; i < m; i++) {
      cin >> from >> to;
      graph[from].insert(to);
      indegree[to]++;
    }

    cout << (has_cycle(graph, indegree) ? "true" : "false") << "\n";
  }

  return 0;
}