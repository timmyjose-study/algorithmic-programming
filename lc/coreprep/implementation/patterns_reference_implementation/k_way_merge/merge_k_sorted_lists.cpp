#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

void display(ListNode *head) {
  while (head != nullptr) {
    cout << head->val << " ";
    head = head->next;
  }
  cout << "\n";
}

struct CompareNode {
  bool operator()(const ListNode *n1, ListNode *n2) {
    return n1->val > n2->val;
  }
};

// O(nlogk) / O(k)
ListNode *merge_k_sorted_lists(const vector<ListNode *> &lists) {
  priority_queue<ListNode *, vector<ListNode *>, CompareNode> min_heap;

  for (ListNode *head : lists) {
    if (head != nullptr) {
      min_heap.push(head);
    }
  }

  ListNode *res_head = nullptr, *tail = nullptr;
  while (!min_heap.empty()) {
    ListNode *node = min_heap.top();
    min_heap.pop();

    if (res_head == nullptr) {
      res_head = tail = new ListNode(node->val);
    } else {
      tail->next = new ListNode(node->val);
      tail = tail->next;
    }

    if (node->next != nullptr) {
      min_heap.push(node->next);
    }
  }

  return res_head;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, val;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<ListNode *> lists;
    for (int i = 0; i < n; i++) {
      cin >> m;

      ListNode *head = nullptr, *tail = nullptr;
      for (int i = 0; i < m; i++) {
        cin >> val;
        if (head == nullptr) {
          head = tail = new ListNode(val);
        } else {
          tail->next = new ListNode(val);
          tail = tail->next;
        }
      }
      lists.emplace_back(head);
    }

    auto res_head = merge_k_sorted_lists(lists);
    display(res_head);
  }

  return 0;
}