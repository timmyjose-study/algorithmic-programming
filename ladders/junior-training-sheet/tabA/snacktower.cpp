#include <iostream>
#include <set>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, curr, d;
  set<int> s;

  cin >> n;
  curr = n;

  for (int i = 0; i < n; i++) {
    cin >> d;

    if (d != curr) {
      cout << "\n";
      s.insert(d);
    } else {
      cout << curr << " ";

      curr--;
      while (s.find(curr) != s.end()) {
        cout << curr << " ";
        s.erase(curr);
        curr--;
      }
      cout << "\n";
    }
  }

  return 0;
}