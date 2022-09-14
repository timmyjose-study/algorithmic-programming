#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print(int n) {
  if (!n) {
    cout << "\n";
    return;
  }

  cout << n;

  if (n > 1) {
    cout << " ";
  }
  print(n - 1);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  print(n);

  return 0;
}