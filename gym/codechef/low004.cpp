#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt;
  string n;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cout << (n[0] - '0' + n[n.size()-1] - '0') << "\n";
  }

  return 0;
}
    

    