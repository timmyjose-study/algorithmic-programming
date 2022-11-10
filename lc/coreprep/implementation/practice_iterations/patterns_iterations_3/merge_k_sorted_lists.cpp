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

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

struct MinComp {
  bool operator()(ListNode *p, ListNode *q) { return p->val > q->val; }
};

// O(nlogk) / O(k)
vector<int> merge(const vector<ListNode *> &a, int k) {
  priority_queue<ListNode *, vector<ListNode *>, MinComp> min_heap;

  for (int i = 0; i < k; i++) {
    if (a[i] != nullptr) {
      min_heap.push(a[i]);
    }
  }

  vector<int> res;
  while (!min_heap.empty()) {
    ListNode *node = min_heap.top();
    min_heap.pop();

    res.push_back(node->val);
    node = node->next;

    if (node != nullptr) {
      min_heap.push(node);
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, k, n, val;
  cin >> tt;

  while (tt--) {
    cin >> k;

    vector<ListNode *> a(k);
    for (int i = 0; i < k; i++) {
      cin >> n;

      ListNode *head = nullptr, *tail = nullptr;
      for (int j = 0; j < n; j++) {
        cin >> val;

        if (head == nullptr) {
          head = tail = new ListNode(val);
        } else {
          tail->next = new ListNode(val);
          tail = tail->next;
        }
      }
      a[i] = head;
    }

    auto res = merge(a, k);
    for (auto r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}