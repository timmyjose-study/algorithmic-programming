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

// O(n) / O(1)
int cycle_length(ListNode *head) {
  ListNode *slow = head, *fast = head;

  while (fast != nullptr && fast->next != nullptr) {
    slow = slow->next;
    fast = fast->next->next;

    if (slow == fast) {
      int len = 0;
      ListNode *curr = slow;

      do {
        curr = curr->next;
        len++;
      } while (curr != slow);

      return len;
    }
  }

  return 0;
}

int main() {
  ios_base::sync_with_stdio(0);
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
      ListNode *curr = head;
      for (int i = 0; i < k - 1; i++) {
        curr = curr->next;
      }
      tail->next = curr;
    }

    cout << cycle_length(head) << "\n";
  }

  return 0;
}