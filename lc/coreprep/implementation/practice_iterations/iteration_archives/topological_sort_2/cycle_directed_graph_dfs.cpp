#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

bool dfs(unordered_map<int, unordered_set<int>> &graph, vector<bool> &visited,
         vector<bool> &call_st, int curr_vertex) {
  if (call_st[curr_vertex]) {
    return true;
  }

  visited[curr_vertex] = true;
  call_st[curr_vertex] = true;

  for (int neighbour : graph[curr_vertex]) {
    if (dfs(graph, visited, call_st, neighbour)) {
      return true;
    }
  }

  call_st[curr_vertex] = false;
  return false;
}

// O(V + E) / O(V + E)
bool has_cycle(unordered_map<int, unordered_set<int>> &graph) {
  vector<bool> visited(graph.size());
  vector<bool> call_st(graph.size());

  for (int i = 0; i < graph.size(); i++) {
    if (!visited[i]) {
      if (dfs(graph, visited, call_st, i)) {
        return true;
      }
    }
  }
  return false;
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

    cin >> m;
    for (int i = 0; i < m; i++) {
      cin >> from >> to;
      graph[from].insert(to);
    }

    cout << has_cycle(graph) << "\n";
  }

  return 0;
}