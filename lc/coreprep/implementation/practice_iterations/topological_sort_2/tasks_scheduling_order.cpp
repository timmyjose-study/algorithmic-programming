#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

using Graph = unordered_map<int, unordered_set<int>>;
using Degree = unordered_map<int, int>;

// O(V + E) / O(V + E)
vector<int> schedule_tasks(Graph &graph, Degree &indegree) {
  queue<int> q;

  for (auto &entry : indegree) {
    if (entry.second == 0) {
      q.push(entry.first);
    }
  }

  vector<int> tasks;
  while (!q.empty()) {
    int task = q.front();
    q.pop();

    tasks.push_back(task);

    for (int neighbour : graph[task]) {
      indegree[neighbour]--;

      if (indegree[neighbour] == 0) {
        q.push(neighbour);
      }
    }
  }

  if (tasks.size() != graph.size()) {
    return vector<int>{};
  }

  return tasks;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, from, to;
  cin >> tt;

  while (tt--) {
    cin >> n;

    Graph graph;
    Degree indegree;

    for (int i = 0; i < n; i++) {
      graph[i] = unordered_set<int>{};
      indegree[i] = 0;
    }

    cin >> m;
    for (int i = 0; i < m; i++) {
      cin >> from >> to;
      graph[from].insert(to);
      indegree[to]++;
    }

    auto tasks = schedule_tasks(graph, indegree);
    for (int task : tasks) {
      cout << task << " ";
    }
    cout << "\n";
  }

  return 0;
}