#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  int n;
  string s;
  vector<int> a;

  cin >> n >> s;

  int cnt = 0;
  int i = 0;
  while (i < n) {
    if (s[i] == 'B') {
      while (i < n && s[i] == 'B') {
        i++;
        cnt++;
      }

      a.push_back(cnt);

      if (i == n) {
        break;
      }

      cnt = 0;
    }
    i++;
  }

  cout << a.size() << "\n";
  if (!a.empty()) {
    for (auto &e : a) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}