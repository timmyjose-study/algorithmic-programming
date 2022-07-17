#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  string alphabet, word;
  int tt;

  cin >> alphabet;

  unordered_set<char> s;
  for (char c : alphabet) {
    s.insert(c);
  }

  auto IsValid = [&](const string &t) {
    for (char c : t) {
      if (!s.count(c)) {
        return false;
      }
    }
    return true;
  };

  cin >> tt;
  while (tt--) {
    cin >> word;
    cout << (IsValid(word) ? "Yes" : "No") << "\n";
  }

  return 0;
}