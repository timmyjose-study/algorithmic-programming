#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print_digits(int curr_pos, string n) {
  if (curr_pos == n.size()) {
    return;
  }

  cout << n[curr_pos] << " ";
  print_digits(curr_pos + 1, n);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;
  cin >> tt;

  while (tt--) {
    cin >> s;
    print_digits(0, s);
    cout << "\n";
  }

  return 0;
}