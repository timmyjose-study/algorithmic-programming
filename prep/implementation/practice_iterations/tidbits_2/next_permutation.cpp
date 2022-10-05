#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

void reverse(vector<int> &a, int from, int to) {
  for (int i = from, j = to; i < j; i++, j--) {
    swap(a, i, j);
  }
}

int next_greater(const vector<int> &a, int inv_pos) {
  for (int i = a.size() - 1; i > inv_pos; i--) {
    if (a[i] > a[inv_pos]) {
      return i;
    }
  }

  return -1;
}

bool next_permutation(vector<int> &a) {
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

  int next_pos = next_greater(a, inv_pos);
  swap(a, inv_pos, next_pos);
  reverse(a, inv_pos + 1, a.size() - 1);

  return true;
}

// O(n) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
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
    } while (next_permutation(a));
  }

  return 0;
}