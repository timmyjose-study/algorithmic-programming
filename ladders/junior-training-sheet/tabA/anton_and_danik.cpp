#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;
  string s;

  cin >> n;
  cin >> s;

  int a = 0, d = 0;
  for (char c : s) {
    if (c == 'A') {
      a++;
    } else {
      d++;
    }
  }

  if (a == d) {
    cout << "Friendship\n";
  } else if (a > d) {
    cout << "Anton\n";
  } else {
    cout << "Danik\n";
  }

  return 0;
}