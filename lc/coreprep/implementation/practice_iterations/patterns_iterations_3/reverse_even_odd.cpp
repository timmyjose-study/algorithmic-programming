#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

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
ListNode *reverse(ListNode *head, int p, int q) {
  if (head == nullptr || head->next == nullptr) {
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

  if (before_from == nullptr) {
    head = prev;
  } else {
    before_from->next = prev;
  }

  return head;
}

int main() {
  ios_base::sync_with_stdio(0);
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

    ListNode *reversed = reverse(head, 1, n / 2);

    if (n % 2 == 0) {
      reversed = reverse(reversed, n / 2 + 1, n);
    } else {
      reversed = reverse(reversed, n / 2 + 2, n);
    }

    display(reversed);
  }

  return 0;
}