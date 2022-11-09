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

bool dfs(Graph &graph, vector<bool> &visited, vector<bool> &call_stack,
         int curr_vertex) {
  if (call_stack[curr_vertex]) {
    return true;
  }

  visited[curr_vertex] = true;
  call_stack[curr_vertex] = true;

  for (int neighbour : graph[curr_vertex]) {
    if (dfs(graph, visited, call_stack, neighbour)) {
      return true;
    }
  }
  call_stack[curr_vertex] = false;

  return false;
}

// O(V + E) / O(V + E)
bool has_cycle(Graph &graph) {
  vector<bool> visited(graph.size(), false);
  vector<bool> call_stack(graph.size(), false);

  for (int i = 0; i < graph.size(); i++) {
    if (!visited[i]) {
      if (dfs(graph, visited, call_stack, i)) {
        return true;
      }
    }
  }
  return false;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, from, to;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;

    Graph graph;
    for (int i = 0; i < n; i++) {
      graph[i] = unordered_set<int>{};
    }

    for (int i = 0; i < m; i++) {
      cin >> from >> to;
      graph[from].insert(to);
    }

    cout << (has_cycle(graph) ? "true" : "false") << "\n";
  }

  return 0;
}