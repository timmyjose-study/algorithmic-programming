#include <iostream>
#include <set>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  set<int> s;
  int c;
  for (int i = 0; i < 4; i++) {
    cin >> c;
    s.insert(c);
  }

  cout << (4 - s.size()) << "\n";

  return 0;
}