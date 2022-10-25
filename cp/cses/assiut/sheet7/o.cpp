#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

unsigned long long fibonacci(int n) {
  if (n == 0) {
    return 0LLU;
  } else if (n == 1) {
    return 1LLU;
  } else {
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  cout << fibonacci(n - 1) << "\n";

  return 0;
}