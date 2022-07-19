// WIP
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  string inp;
  vector<int> a;

  while (cin >> inp) {
    if (inp == "#") {
      int len = a.size();
      int pos = len / 2;
      cout << a[pos] << "\n";
      a.erase(a.begin() + pos);
    } else {
      a.push_back(stoi(inp));
      sort(a.begin(), a.end());
    }
  }

  return 0;
}