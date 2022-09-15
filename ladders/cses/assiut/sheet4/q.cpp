#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto split = [](const string &s) {
    vector<string> a;

    string word = "";
    bool in_word = true;
    int i = 0;
    while (i < s.size()) {
      if (in_word) {
        while (i < s.size() && s[i] != ' ') {
          word += s[i++];
        }

        a.push_back(word);
        word = "";
        in_word = false;
        if (i == s.size()) {
          break;
        }

      } else {
        while (i < s.size() && s[i++] == ' ')
          ;
        i--;
        in_word = true;
      }
    }

    return a;
  };

  auto reverse = [](string &s) {
    for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
      char c = s[i];
      s[i] = s[j];
      s[j] = c;
    }
  };

  string s;
  getline(cin, s);

  vector<string> words = split(s);
  for (auto &w : words) {
    reverse(w);
  }

  for (int i = 0; i < words.size(); i++) {
    cout << words[i];
    if (i < words.size() - 1) {
      cout << " ";
    }
  }
  cout << "\n";

  return 0;
}