#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

ListNode *reverse(ListNode *head) {
  if (head == nullptr || head->next == nullptr) {
    return head;
  }

  ListNode *prev = nullptr, *curr = head, *next = nullptr;
  while (curr != nullptr) {
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
  }

  return prev;
}

void display(ListNode *head) {
  while (head != nullptr) {
    cout << head->val << " ";
    head = head->next;
  }
  cout << "\n";
}

// O(n) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, val;
  cin >> tt;

  while (tt--) {
    cin >> n;

    cin >> val;
    ListNode *head = new ListNode(val);
    ListNode *curr = head;

    for (int i = 1; i < n; i++) {
      cin >> val;
      curr->next = new ListNode(val);
      curr = curr->next;
    }

    head = reverse(head);
    display(head);
  }

  return 0;
}