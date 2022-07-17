#include <iostream>
#include <string>

using namespace std;

int main() {
  string s, t;

  cin >> s >> t;
  cout << (s.size() >= t.size() ? "go" : "no") << "\n";

  return 0;
}