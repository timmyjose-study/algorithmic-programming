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
int start_of_cycle(ListNode *head) {
  ListNode *slow = head, *fast = head;

  while (fast != nullptr && fast->next != nullptr) {
    slow = slow->next;
    fast = fast->next->next;

    if (slow == fast) {
      ListNode *beg = head;
      while (beg != slow) {
        beg = beg->next;
        slow = slow->next;
      }
      return beg->val;
    }
  }

  return -1;
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

    cout << start_of_cycle(head) << "\n";
  }

  return 0;
}