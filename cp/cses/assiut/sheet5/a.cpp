#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int add(int n, int m) { return n + m; }

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  cout << add(n, m) << "\n";

  return 0;
}