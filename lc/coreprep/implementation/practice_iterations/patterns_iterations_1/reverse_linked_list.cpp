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

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, val;
  cin >> tt;

  while (tt--) {
    cin >> n;

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

    ListNode *rev_head = reverse(head);
    display(rev_head);
  }

  return 0;
}