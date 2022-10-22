#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long n, k, a;
  cin >> n >> k >> a;

  long long p = n * k;
  if (p % a != 0) {
    cout << "double\n";
  } else {
    long long r = p / a;
    if (r >= -2147483648LL && r <= 2147483647LL) {
      cout << "int\n";
    } else {
      cout << "long long\n";
    }
  }

  return 0;
}