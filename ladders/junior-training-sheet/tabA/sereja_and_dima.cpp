#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, e;

  cin >> n;
  vector<int> a(n);

  for (int i = 0; i < n; i++) {
    cin >> e;
    a[i] = e;
  }

  int front = 0, rear = n - 1, s = 0, d = 0;

  bool sturn = true;
  while (front <= rear) {
    if (sturn) {
      if (a[front] > a[rear]) {
        s += a[front];
        front++;
      } else {
        s += a[rear];
        rear--;
      }
      sturn = false;
    } else {
      if (a[front] > a[rear]) {
        d += a[front];
        front++;
      } else {
        d += a[rear];
        rear--;
      }
      sturn = true;
    }
  }

  cout << s << " " << d << "\n";

  return 0;
}