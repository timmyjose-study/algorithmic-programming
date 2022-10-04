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

int start_of_cycle(ListNode *head) {
  ListNode *fast = head, *slow = head;

  while (fast != nullptr && fast->next != nullptr) {
    fast = fast->next->next;
    slow = slow->next;

    if (fast == slow) {
      slow = head;

      while (slow != fast) {
        slow = slow->next;
        fast = fast->next;
      }

      return slow->val;
    }
  }
  return -1;
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

    cout << start_of_cycle(head) << "\n";
  }

  return 0;
}