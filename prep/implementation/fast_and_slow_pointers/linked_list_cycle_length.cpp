#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) {
    this->val = val;
    this->next = nullptr;
  }

  ~ListNode() {
    if (this->next) {
      delete this->next;
    }
  }
};

int cycle_length(ListNode *head) {
  ListNode *fast = head, *slow = head;

  while (fast != nullptr && fast->next != nullptr) {
    fast = fast->next->next;
    slow = slow->next;

    if (fast == slow) {
      int len = 0;
      ListNode *slow_copy = slow;

      do {
        slow_copy = slow_copy->next;
        len++;
      } while (slow_copy != slow);

      return len;
    }
  }

  return 0;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    ListNode *head = new ListNode(1);
    ListNode *curr = head;
    for (int i = 2; i <= n; i++) {
      curr->next = new ListNode(i);
      curr = curr->next;
    }

    if (k != -1) {
      ListNode *tmp = head;
      for (int i = 0; i < k - 1; i++) {
        tmp = tmp->next;
      }
      curr->next = tmp;
    }

    cout << cycle_length(head) << "\n";
  }

  return 0;
}