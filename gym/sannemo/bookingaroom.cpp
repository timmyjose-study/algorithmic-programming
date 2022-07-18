#include <algorithm>
#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  int r, b;
  unordered_set<int> s;

  cin >> r >> b;

  int d;
  for (int i = 0; i < b; i++) {
    cin >> d;
    s.insert(d);
  }

  for (int i = 1; i <= r; i++) {
    if (s.find(i) == s.end()) {
      cout << i << "\n";
      return 0;
    }
  }

  cout << "too late\n";

  return 0;
}