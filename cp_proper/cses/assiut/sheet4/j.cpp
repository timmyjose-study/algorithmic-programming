#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int N = 26;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int freq[N] = {0};

  string s;
  cin >> s;

  for (char c : s) {
    freq[c - 'a']++;
  }

  for (int i = 0; i < N; i++) {
    if (!freq[i]) {
      continue;
    }
    cout << (char)('a' + i) << " : " << freq[i] << "\n";
  }

  return 0;
}