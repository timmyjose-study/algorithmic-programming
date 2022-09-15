#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, m;
  cin >> n >> m;

  if (n > m) {
    int t = n;
    n = m;
    m = t;
  }

  unsigned long long nterms, start, end;
  unsigned long long s = 0ULL, es = 0ULL, os = 0LL;

  unsigned long long sn = (n * (n - 1)) / 2;
  unsigned long long sm = (m * (m + 1)) / 2;
  s = (sm - sn);

  start = (n % 2 == 0) ? n : n + 1;
  end = (m % 2 == 0) ? m : m - 1;
  nterms = 1 + (end - start) / 2;
  es = (nterms * (start + end)) / 2;

  start = (n % 2 == 0) ? n + 1 : n;
  end = (m % 2 == 0) ? m - 1 : m;
  nterms = 1 + (end - start) / 2;
  os = (nterms * (start + end)) / 2;

  cout << s << "\n" << es << "\n" << os << "\n";

  return 0;
}