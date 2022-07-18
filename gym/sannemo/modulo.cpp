#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  int n;
  unordered_set<int> s;

  while (cin >> n) {
    s.insert((n % 42));
  }

  cout << s.size() << "\n";

  return 0;
}