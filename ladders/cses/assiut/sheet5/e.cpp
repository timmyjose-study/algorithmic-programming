#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void swap(int &n, int &m) {
  int t = n;
  n = m;
  m = t;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  swap(n, m);
  cout << n << " " << m << "\n";

  return 0;
}