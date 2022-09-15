#include <iostream>
#include <string>

using namespace std;

const int N = 100;

void sort(string s, int n) {}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  int a[N] = {0};
  char c;

  for (int i = 0; i < n; i++) {
    cin >> c;
    a[c - 'a']++;
  }

  for (int i = 0; i < 26; i++) {
    int f = a[i];
    while (f--) {
      cout << ((char)('a' + i));
    }
  }
  cout << "\n";

  return 0;
}