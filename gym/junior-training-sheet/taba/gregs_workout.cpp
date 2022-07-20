#include <iostream>

using namespace std;

int main() {
  int n, m;
  int chest = 0, biceps = 0, back = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> m;
    if (i % 3 == 0) {
      chest += m;
    } else if (i % 3 == 1) {
      biceps += m;
    } else {
      back += m;
    }
  }

  if (chest > biceps) {
    if (chest > back) {
      cout << "chest\n";
    } else {
      cout << "back\n";
    }
  } else if (biceps > back) {
    cout << "biceps\n";
  } else {
    cout << "back\n";
  }

  return 0;
}