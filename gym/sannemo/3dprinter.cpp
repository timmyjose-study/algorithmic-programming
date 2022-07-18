#include <iostream>

using namespace std;

int main() {
  int es, np = 1, nd = 0, ns = 0;

  cin >> es;
  while (ns < es) {
    if ((es - ns) > np) {
      nd++;
      np *= 2;
    } else {
      nd++;
      ns += np;
    }
  }

  cout << nd << "\n";
}