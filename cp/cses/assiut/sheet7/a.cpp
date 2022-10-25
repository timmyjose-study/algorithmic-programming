#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print(int n) {
  if (!n) {
    return;
  }

  cout << "I love Recursion"
       << "\n";
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