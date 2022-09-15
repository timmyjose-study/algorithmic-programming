#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto count_words = [](const string &s) {
    int len = s.size(), i = 0;
    bool in_word = false;
    int cnt = 0;

    while (true) {
      if (!in_word) {
        while (i < len && !isalpha(s[i])) {
          i++;
        }

        if (i == len) {
          break;
        }

        in_word = true;
      } else {
        while (i < len && isalpha(s[i])) {
          i++;
        }

        if (i == len) {
          cnt++;
          break;
        }
        cnt++;

        in_word = false;
      }
    }

    return cnt;
  };

  string s;
  getline(cin, s);

  cout << count_words(s) << "\n";

  return 0;
}