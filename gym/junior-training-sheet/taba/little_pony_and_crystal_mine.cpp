#include <array>
#include <iostream>

using namespace std;

const int N = 110;

int main() {
  int n;
  array<array<char, N>, N> a;

  for (auto &r : a) {
    r.fill('*');
  }

  cin >> n;

  int mid = n / 2;
  for (int i = 0; i < mid; i++) {
    a[i][mid] = 'D';
    for (int j = mid - 1; j >= mid - i; j--) {
      a[i][j] = 'D';
    }

    for (int j = mid + 1; j <= mid + i; j++) {
      a[i][j] = 'D';
    }
  }

  a[mid].fill('D');

  for (int i = mid + 1; i < n; i++) {
    a[i][mid] = 'D';
    for (int j = mid - 1; j > mid - n + i; j--) {
      a[i][j] = 'D';
    }

    for (int j = mid + 1; j < n - i + mid; j++) {
      a[i][j] = 'D';
    }
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cout << a[i][j];
    }
    cout << "\n";
  }

  return 0;
}