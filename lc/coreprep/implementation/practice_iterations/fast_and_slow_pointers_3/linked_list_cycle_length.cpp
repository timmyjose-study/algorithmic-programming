#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

int cycle_length(ListNode *head) {
  ListNode *fast = head, *slow = head;

  while (fast != nullptr && fast->next != nullptr) {
    fast = fast->next->next;
    slow = slow->next;

    if (fast == slow) {
      ListNode *tmp = slow;
      int len = 0;

      do {
        tmp = tmp->next;
        len++;
      } while (tmp != slow);

      return len;
    }
  }

  return 0;
}

// O(n) / O(1)
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