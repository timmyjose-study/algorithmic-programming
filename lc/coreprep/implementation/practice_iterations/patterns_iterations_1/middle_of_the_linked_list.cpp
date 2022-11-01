#include <algorithm>
#include <iostream>
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

// O(n) / O(1)
int middle_of_the_list(ListNode *head) {
  ListNode *slow = head, *fast = head;

  while (fast != nullptr && fast->next != nullptr) {
    slow = slow->next;
    fast = fast->next->next;
  }

  return slow->val;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    ListNode *head = nullptr, *tail = nullptr;
    for (int i = 1; i <= n; i++) {
      if (head == nullptr) {
        head = tail = new ListNode(i);
      } else {
        tail->next = new ListNode(i);
        tail = tail->next;
      }
    }

    if (k != -1) {
      cout << -1 << "\n";
    } else {

      cout << middle_of_the_list(head) << "\n";
    }
  }

  return 0;
}