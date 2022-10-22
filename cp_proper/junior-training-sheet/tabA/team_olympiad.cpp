#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  int ac = 0, bc = 0, cc = 0;

  for (int i = 0; i < n; i++) {
    cin >> a[i];
    switch (a[i]) {
    case 1:
      ac++;
      break;
    case 2:
      bc++;
      break;
    case 3:
      cc++;
      break;
    }
  }

  int nteams = min(min(ac, bc), cc);
  cout << nteams << "\n";

  if (nteams) {
    int apos = -1, bpos = -1, cpos = -1;
    for (int i = 0; i < nteams; i++) {
      for (int i = 0; i < n; i++) {
        if (apos == -1 && a[i] == 1) {
          apos = i + 1;
          a[i] = 0;
          cout << apos << " ";
        }

        if (bpos == -1 && a[i] == 2) {
          bpos = i + 1;
          a[i] = 0;
          cout << bpos << " ";
        }

        if (cpos == -1 && a[i] == 3) {
          cpos = i + 1;
          a[i] = 0;
          cout << cpos << " ";
        }
      }
      cout << "\n";
      apos = bpos = cpos = -1;
    }
  }

  return 0;
}