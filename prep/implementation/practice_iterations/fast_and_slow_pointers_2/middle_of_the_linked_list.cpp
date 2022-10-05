#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val) { this->next = nullptr; }
};

int middle_of_list(ListNode *head) {
  ListNode *fast = head, *slow = head;

  while (fast != nullptr && fast->next != nullptr) {
    fast = fast->next->next;
    slow = slow->next;
  }

  return slow->val;
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
      for (int j = 0; j < k - 1; j++) {
        tmp = tmp->next;
      }
      curr->next = tmp;
    }

    cout << middle_of_list(head) << "\n";
  }

  return 0;
}