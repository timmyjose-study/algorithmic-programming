#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;
  cin >> n;

  set<int> s;
  for (int i = 0; i < n; i++) {
    cin >> d;
    s.insert(d);
  }

  cout << s.size() << "\n";

  return 0;
}