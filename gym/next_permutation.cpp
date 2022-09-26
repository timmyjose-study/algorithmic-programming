#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

int next_greater(vector<int> &a, int k) {
  for (int i = a.size() - 1; i > 0; i--) {
    if (a[i] > k) {
      return i;
    }
  }
  return -1;
}

void reverse(vector<int> &a, int from, int to) {
  for (int i = from, j = to; i < j; i++, j--) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}

bool next_perm(vector<int> &a) {
  int inv_pos = -1;
  for (int i = a.size() - 1; i > 0; i--) {
    if (a[i] > a[i - 1]) {
      inv_pos = i - 1;
      break;
    }
  }

  if (inv_pos == -1) {
    return false;
  }

  int next = next_greater(a, a[inv_pos]);
  swap(a, inv_pos, next);
  reverse(a, inv_pos + 1, a.size() - 1);

  return true;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  do {
    for (int e : a) {
      cout << e << " ";
    }
    cout << "\n";
  } while (next_perm(a));

  return 0;
}