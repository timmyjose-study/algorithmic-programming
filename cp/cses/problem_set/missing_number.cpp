#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, d;
  cin >> n;

  unsigned long long es = n * (n + 1) / 2, as = 0;
  for (int i = 0; i < n - 1; i++) {
    cin >> d;
    as += d;
  }

  cout << (es - as) << "\n";

  return 0;
}