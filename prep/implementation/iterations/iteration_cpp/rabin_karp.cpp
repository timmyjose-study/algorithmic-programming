#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> rabin_karp(const string &s, string &t) {
  long m = 53L;
  long p = (long)1e9 + 7;
  int slen = s.size(), tlen = t.size();

  vector<long> mpow(max(slen, tlen));
  mpow[0] = 1L;
  for (int i = 1; i < mpow.size(); i++) {
    mpow[i] = (mpow[i - 1] * m) % p;
  }

  long shash = 0L;
  for (int i = 0; i < slen; i++) {
    shash = (shash + (s[i] - 'a' + 1) * mpow[i]) % p;
  }

  if (shash < 0) {
    shash += p;
  }

  vector<long> thashes(tlen + 1);
  thashes[0] = 0L;
  for (int i = 0; i < tlen; i++) {
    thashes[i + 1] = (thashes[i] + (t[i] - 'a' + 1) * mpow[i]) % p;
  }

  for (int i = 0; i <= tlen; i++) {
    if (thashes[i] < 0) {
      thashes[i] += p;
    }
  }

  vector<int> positions;
  for (int i = 0; i < tlen - slen + 1; i++) {
    long rolling_hash = (thashes[i + slen] + p - thashes[i]) % p;

    if (rolling_hash == shash * mpow[i] % p) {
      positions.push_back(i);
    }
  }

  return positions;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  cin.ignore(1);

  string s, t;
  for (int i = 0; i < n; i++) {
    getline(cin, s);
    getline(cin, t);

    auto positions = rabin_karp(s, t);

    if (positions.empty()) {
      cout << -1 << "\n";
    } else {

      cout << positions.size() << "\n";
      for (int pos : positions) {
        cout << pos << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}