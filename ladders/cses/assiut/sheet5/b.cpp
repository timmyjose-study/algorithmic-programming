#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print(int n) {
  for (int i = 1; i <= n; i++) {
    cout << i;
    if (i < n) {
      cout << " ";
    }
  }
  cout << "\n";
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  print(n);

  return 0;
}