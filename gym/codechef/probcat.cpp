#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt, diff;

  cin >> tt;
  while (tt--) {
    cin >> diff;
    if (diff >= 1 && diff < 100) {
      cout << "Easy\n";
    } else if (diff >= 100 && diff < 200) {
      cout << "Medium\n";
    } else if (diff >= 200 && diff <= 300) {
      cout << "Hard\n";
    }
  }

  return 0;
}