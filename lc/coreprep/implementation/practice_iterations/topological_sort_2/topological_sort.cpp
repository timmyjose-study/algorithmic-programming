#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(V + E) / O(V + E)
vector<int> topological_sort(unordered_map<int, unordered_set<int>> &graph,
                             unordered_map<int, int> &indegree) {
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
    cin >> n;

    unordered_map<int, unordered_set<int>> graph;
    for (int i = 0; i < n; i++) {
      graph[i] = unordered_set<int>{};
    }

    unordered_map<int, int> indegree;
    for (int i = 0; i < n; i++) {
      indegree[i] = 0;
    }

    cin >> m;
    for (int i = 0; i < m; i++) {
      cin >> from >> to;
      graph[from].insert(to);
      indegree[to]++;
    }

    auto ordering = topological_sort(graph, indegree);
    for (int v : ordering) {
      cout << v << " ";
    }
    cout << "\n";
  }

  return 0;
}