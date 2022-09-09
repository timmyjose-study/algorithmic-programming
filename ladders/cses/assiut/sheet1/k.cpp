#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b, c;

  cin >> a >> b >> c;

  int min = -1, max = -1;

  if (a > b) {
    if (a > c) {
      max = a;
    } else if (b > c) {
      max = b;
    } else {
      max = c;
    }
  } else if (b > c) {
    max = b;
  } else {
    max = c;
  }

  if (a < b) {
    if (a < c) {
      min = a;
    } else if (b < c) {
      min = b;
    } else {
      min = c;
    }
  } else if (b < c) {
    min = b;
  } else {
    min = c;
  }

  cout << min << " " << max << "\n";

  return 0;
}