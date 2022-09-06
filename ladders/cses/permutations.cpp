#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  if (n == 1) {
    cout << 1 << "\n";
    return 0;
  }

  if (n < 4) {
    cout << "NO SOLUTION\n";
  } else {
    int ne = n / 2;
    int no = n - ne;

    for (int e = (1 + (no - 1) * 2); e >= 1; e -= 2) {
      cout << e << " ";
    }

    for (int e = (2 + (ne - 1) * 2); e >= 2; e -= 2) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}