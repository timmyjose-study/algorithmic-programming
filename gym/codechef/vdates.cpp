#include <iostream>

using namespace std;

int main() {
  int tt, before, low, high;

  cin >> tt;
  while (tt--) {
    cin >> before >> low >> high;

    if (before < low) {
      cout << "Too Early\n";
    } else if (before >= low && before <= high) {
      cout << "Take second dose now\n";
    } else if (before > high) {
      cout << "Too Late\n";
    }
  }

  return 0;
}