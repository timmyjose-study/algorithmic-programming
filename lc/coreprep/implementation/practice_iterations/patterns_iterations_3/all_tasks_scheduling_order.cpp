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

void all_scheduling_orders(Graph &graph, Degree &indegree, deque<int> q,
                           vector<int> &curr_schedule,
                           vector<vector<int>> &all_schedules) {
  if (!q.empty()) {
    for (int v : q) {
      deque<int> next_q(q.begin(), q.end());
      next_q.erase(remove(next_q.begin(), next_q.end(), v), next_q.end());

      curr_schedule.push_back(v);

      for (int neighbour : graph[v]) {
        indegree[neighbour]--;

        if (indegree[neighbour] == 0) {
          next_q.push_back(neighbour);
        }
      }

      all_scheduling_orders(graph, indegree, next_q, curr_schedule,
                            all_schedules);

      curr_schedule.pop_back();

      for (int neighbour : graph[v]) {
        indegree[neighbour]++;
      }
    }
  }

  if (curr_schedule.size() == graph.size()) {
    all_schedules.push_back(curr_schedule);
  }
}

// O(V! x E) / O(V! x E)
vector<vector<int>> all_scheduling_orders(Graph &graph, Degree &indegree) {
  deque<int> q;

  for (auto entry : indegree) {
    if (entry.second == 0) {
      q.push_back(entry.first);
    }
  }

  vector<vector<int>> all_schedules;
  vector<int> curr_schedule;

  all_scheduling_orders(graph, indegree, q, curr_schedule, all_schedules);

  return all_schedules;
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

    auto res = all_scheduling_orders(graph, indegree);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}