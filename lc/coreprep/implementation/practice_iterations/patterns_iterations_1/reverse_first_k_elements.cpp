#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

// O(n) / O(1)
ListNode *reverse(ListNode *head, int p, int q) {
  if (head == nullptr) {
    return head;
  }

  ListNode *before_from = nullptr, *from = head, *to = head,
           *after_to = nullptr;

  for (int i = 0; i < p - 1; i++) {
    before_from = from;
    from = from->next;
  }

  for (int i = 0; i < q - 1; i++) {
    to = to->next;
  }
  after_to = to->next;

  ListNode *prev = after_to, *curr = from, *next = nullptr;
  while (curr != after_to) {
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
  }

  ListNode *new_head = nullptr;
  if (before_from == nullptr) {
    new_head = prev;
  } else {
    new_head = head;
    before_from->next = prev;
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

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, val;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    ListNode *head = nullptr, *tail = nullptr;
    for (int i = 0; i < n; i++) {
      cin >> val;

      if (head == nullptr) {
        head = tail = new ListNode(val);
      } else {
        tail->next = new ListNode(val);
        tail = tail->next;
      }
    }

    ListNode *new_head = reverse(head, 1, k);
    display(new_head);
  }

  return 0;
}