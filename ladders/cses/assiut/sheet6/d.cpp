#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

unsigned long long func(unsigned long long a, unsigned long long b,
                        unsigned long long q,
                        map<unsigned long long, unsigned long long> m) {
  if (q == 1) {
    return a;
  }

  if (q == 2) {
    return b;
  }

  unsigned long long lval;
  if (m.find(q - 1) == m.end()) {
    lval = func(a, b, q - 1, m);
  } else {
    lval = m[q - 1];
  }

  unsigned long long rval;
  if (m.find(q - 2) == m.end()) {
    rval = func(a, b, q - 2, m);
  } else {
    rval = m[q - 2];
  }

  m[q] = lval ^ rval;

  return lval ^ rval;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long a, b, q;
  map<unsigned long long, unsigned long long> m;
  cin >> a >> b >> q;
  cout << func(a, b, q, m) << "\n";

  return 0;
}