#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

struct CompMerge {
  bool operator()(const ListNode *n1, const ListNode *n2) {
    return n1->val > n2->val;
  }
};

// O(nlogk) / O(k)
ListNode *merge_k_sorted_lists(const vector<ListNode *> &a) {
  priority_queue<ListNode *, vector<ListNode *>, CompMerge> min_heap;

  ListNode *merged_head = nullptr, *merged_tail = nullptr;

  for (int i = 0; i < a.size(); i++) {
    min_heap.push(a[i]);
  }

  while (!min_heap.empty()) {
    ListNode *node = min_heap.top();
    min_heap.pop();

    if (merged_head == nullptr) {
      merged_head = merged_tail = new ListNode(node->val);
    } else {
      merged_tail->next = new ListNode(node->val);
      merged_tail = merged_tail->next;
    }

    node = node->next;
    if (node != nullptr) {
      min_heap.push(node);
    }
  }

  return merged_head;
}

void display(ListNode *head) {
  while (head != nullptr) {
    cout << head->val << " ";
    head = head->next;
  }
  cout << "\n";
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
      ListNode *head = nullptr, *tail = nullptr;
      cin >> n;

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

    ListNode *merged = merge_k_sorted_lists(a);
    display(merged);
  }

  return 0;
}