#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

unsigned long long x2dec(string n, unsigned long long b) {
  unsigned long long res = 0ULL;
  for (char c : n) {
    if (c >= '0' && c <= '9') {
      res = b * res + (c - '0');
    } else {
      res = b * res + (c - 'A' + 10);
    }
  }

  return res;
}

string dec2x(unsigned long long n, int b) {
  string res = "";

  while (n) {
    int d = n % b;
    if (d < 10) {
      res += to_string(d);
    } else {
      res += (char)('A' + (d - 10));
    }

    n /= b;
  }

  for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
    char c = res[i];
    res[i] = res[j];
    res[j] = c;
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int t;
  cin >> t;

  unsigned long long n, b;
  string s;
  if (t == 1) {
    string s;
    cin >> s >> b;
    cout << x2dec(s, b) << "\n";

  } else {
    cin >> n >> b;
    cout << dec2x(n, b) << "\n";
  }

  return 0;
}