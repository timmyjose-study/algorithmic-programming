#include <iostream>

using namespace std;

int main() {
  int hh, mm;

  cin >> hh >> mm;

  if (!hh) {
    hh = 24;
  }

  int mins = hh * 60 + mm - 45;
  cout << (mins / 60) << " " << (mins % 60) << "\n";

  return 0;
}