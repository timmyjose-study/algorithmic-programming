#include <algorithm>
#include <iostream>

using namespace std;

const int N = 110;

void sort(int a[], int n) {
  for (int i = 1; i < n; i++) {
    int k = a[i];
    int j = i - 1;

    while (j >= 0 && a[j] >= k) {
      a[j + 1] = a[j];
      j--;
    }
    a[j + 1] = k;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  int a[N];

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a, n);

  for (int i = 0; i < n; i++) {
    cout << a[i] << " ";
  }
  cout << "\n";

  return 0;
}