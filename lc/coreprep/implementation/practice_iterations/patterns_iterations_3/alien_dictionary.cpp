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

using Graph = unordered_map<char, unordered_set<char>>;
using Degree = unordered_map<char, int>;

// O(V + E) / O(V + E)
string topological_sort(Graph &graph, Degree &indegree) {
  queue<int> q;
  for (auto entry : indegree) {
    if (entry.second == 0) {
      q.push(entry.first);
    }
  }

  string res = "";
  while (!q.empty()) {
    char v = q.front();
    q.pop();

    res += v;

    for (char neighbour : graph[v]) {
      indegree[neighbour]--;

      if (indegree[neighbour] == 0) {
        q.push(neighbour);
      }
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin.ignore(1, '\n');

    vector<string> words(n);
    for (int i = 0; i < n; i++) {
      cin >> words[i];
    }

    Graph graph;
    Degree indegree;

    for (string &w : words) {
      for (char c : w) {
        if (graph.find(c) == graph.end()) {
          graph[c] = unordered_set<char>{};
          indegree[c] = 0;
        }
      }
    }

    for (int i = 0; i < n - 1; i++) {
      string &a = words[i];
      string &b = words[i + 1];

      int len = min(a.size(), b.size());
      for (int j = 0; j < len; j++) {
        if (a[j] != b[j]) {
          if (graph[a[j]].find(b[j]) == graph[a[j]].end()) {
            graph[a[j]].insert(b[j]);
            indegree[b[j]]++;
          }
          break;
        }
      }
    }

    cout << topological_sort(graph, indegree) << "\n";
  }

  return 0;
}