#include <iostream>
#include <string>

using namespace std;

int main() {
  int n, h;
  string s;

  cin >> n >> h;
  for (int i = 0; i < n; i++) {
    getline(cin, s);
  }

  cout << h << "\n";

  return 0;
}