#include <iostream>

using namespace std;

int main() {
  int n, p, q;

  cin >> n >> p >> q;

  long long games = (long long)p + (long long)q;
  games /= n;
  cout << (games % 2 == 0 ? "paul" : "opponent") << "\n";

  return 0;
}