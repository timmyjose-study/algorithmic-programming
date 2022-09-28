#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

long polyhash(const string &s) {
  long m = 53;
  long p = (long)1e9 + 7;
  long mpow = 1L;

  long hash = 0L;
  for (int i = s.size() - 1; i >= 0; i--) {
    hash = (hash + (s[i] - 'a' + 1) * mpow) % p;
    mpow = (mpow * m) % p;
  }

  return hash;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  cin.ignore(1);

  string s;
  for (int i = 0; i < n; i++) {
    getline(cin, s);
    cout << polyhash(s) << "\n";
  }

  return 0;
}