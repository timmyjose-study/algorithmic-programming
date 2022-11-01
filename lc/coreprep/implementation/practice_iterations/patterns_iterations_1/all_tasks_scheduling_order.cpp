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

void all_tasks_scheduling(Graph &graph, Degree &indegree, deque<int> q,
                          vector<int> &curr, vector<vector<int>> &all) {
  if (!q.empty()) {
    deque<int> vs = q;

    while (!vs.empty()) {
      int v = vs.front();
      vs.pop_front();

      curr.push_back(v);
      deque<int> nextq = q;
      nextq.erase(remove(nextq.begin(), nextq.end(), v), nextq.end());

      for (int neighbour : graph[v]) {
        indegree[neighbour]--;

        if (indegree[neighbour] == 0) {
          nextq.push_back(neighbour);
        }
      }

      all_tasks_scheduling(graph, indegree, nextq, curr, all);

      curr.pop_back();
      for (int neighbour : graph[v]) {
        indegree[neighbour]++;
      }
    }
  }

  if (curr.size() == graph.size()) {
    all.push_back(curr);
  }
}

// O(V! x E) / O(V! x E)
vector<vector<int>> all_tasks_scheduling(Graph &graph, Degree &indegree) {
  deque<int> q;
  for (auto entry : indegree) {
    if (entry.second == 0) {
      q.push_back(entry.first);
    }
  }

  vector<vector<int>> res;
  vector<int> curr;
  all_tasks_scheduling(graph, indegree, q, curr, res);

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

    auto res = all_tasks_scheduling(graph, indegree);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}