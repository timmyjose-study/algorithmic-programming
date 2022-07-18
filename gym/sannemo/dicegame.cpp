#include <iostream>

using namespace std;

int main() {
  int d, s1 = 0, s2 = 0;

  for (int i = 0; i < 4; i++) {
    cin >> d;
    s1 += d;
  }

  for (int i = 0; i < 4; i++) {
    cin >> d;
    s2 += d;
  }

  cout << (s1 < s2 ? "Emma" : (s1 > s2 ? "Gunnar" : "Tie")) << "\n";

  return 0;
}