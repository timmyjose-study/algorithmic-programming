#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;

  ListNode(int val) : val(val), next(nullptr) {}
};

ListNode *reverse(ListNode *head, int p, int q) {
  if (head == nullptr || head->next == nullptr) {
    return head;
  }

  ListNode *before_start = nullptr, *start = head, *end = head,
           *after_end = nullptr;

  for (int i = 0; i < p - 1; i++) {
    before_start = start;
    start = start->next;
  }

  for (int j = 0; j < q - 1; j++) {
    end = end->next;
  }
  after_end = end->next;

  ListNode *prev = nullptr, *curr = start, *next = nullptr;
  while (curr != after_end) {
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
  }

  if (before_start == nullptr) {
    head = prev;
  } else {
    before_start->next = prev;
  }
  start->next = after_end;

  return head;
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

  int tt, n, val, start, end;
  cin >> tt;

  while (tt--) {
    cin >> n >> start >> end;

    cin >> val;
    ListNode *head = new ListNode(val);
    ListNode *curr = head;

    for (int i = 1; i < n; i++) {
      cin >> val;
      curr->next = new ListNode(val);
      curr = curr->next;
    }

    head = reverse(head, start, end);
    display(head);
  }

  return 0;
}