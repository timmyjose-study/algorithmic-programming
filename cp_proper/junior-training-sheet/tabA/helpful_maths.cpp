#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  vector<int> a;

  cin >> s;

  for (int c : s) {
    switch (c) {
    case '1':
    case '2':
    case '3':
      a.emplace_back(c - '0');
      break;
    }
  }

  sort(a.begin(), a.end());

  for (int i = 0; i < a.size() - 1; i++) {
    cout << a[i] << "+";
  }
  cout << a[a.size() - 1] << "\n";

  return 0;
}