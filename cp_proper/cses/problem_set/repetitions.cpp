#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  int slen = s.size();
  int max_len = 0;

  char c = s[0];
  int curr_len = 1;
  int i = 1;

  while (true) {
    while (i < slen && (s[i] == c)) {
      curr_len++;
      i++;
    }

    if (curr_len > max_len) {
      max_len = curr_len;
    }

    if (i == slen) {
      break;
    }

    curr_len = 1;
    c = s[i];
    i++;
  }

  cout << max_len << "\n";

  return 0;
}