#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

using Graph = unordered_map<char, unordered_set<char>>;
using Degree = unordered_map<char, int>;

// O(V + E) / O(V + E)
string topological_sort(Graph &graph, Degree &indegree) {
  queue<char> q;
  for (auto &entry : indegree) {
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

void preprocess(Graph &graph, Degree &indegree, const vector<string> &words) {
  int n = words.size();

  for (const string &w : words) {
    for (char v : w) {
      if (graph.find(v) == graph.end()) {
        graph[v] = unordered_set<char>{};
        indegree[v] = 0;
      }
    }
  }

  for (int i = 0; i < n - 1; i++) {
    string w1 = words[i];
    string w2 = words[i + 1];

    int len = min(w1.size(), w2.size());
    for (int j = 0; j < len; j++) {
      if (w1[j] != w2[j]) {
        if (graph[w1[j]].find(w2[j]) == graph[w1[j]].end()) {
          graph[w1[j]].insert(w2[j]);
          indegree[w2[j]]++;
        }
        break;
      }
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
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

    preprocess(graph, indegree, words);
    cout << topological_sort(graph, indegree) << "\n";
  }

  return 0;
}