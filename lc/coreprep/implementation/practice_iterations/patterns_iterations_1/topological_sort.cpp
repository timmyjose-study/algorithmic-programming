#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

using Graph = unordered_map<int, unordered_set<int>>;
using Degree = unordered_map<int, int>;

// O(V + E) / O(V + E)
vector<int> sort(Graph &graph, Degree &indegree) {
  queue<int> q;

  for (auto &entry : indegree) {
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

  if (res.size() != graph.size()) {
    throw "cycle detected";
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
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

    auto ordering = sort(graph, indegree);
    for (int v : ordering) {
      cout << v << " ";
    }
    cout << "\n";
  }

  return 0;
}