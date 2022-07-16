#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;

    if (s == "b" || s == "B") {
      cout << "BattleShip\n";
    } else if (s == "c" | s == "C") {
      cout << "Cruiser\n";
    } else if (s == "d" || s == "D") {
      cout << "Destroyer\n";
    } else {
      cout << "Frigate\n";
    }
  }

  return 0;
}
