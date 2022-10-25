#include <cmath>
#include <iostream>
#include <string>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  if (s.find(".") == string::npos) {
    cout << "int " << stoi(s) << "\n";
  } else {
    auto pos = s.find(".");
    double frac = stod(s.substr(pos + 1, s.size() - pos));
    if (fabs(frac - 0.0) < EPS) {
      cout << "int " << s.substr(0, pos) << "\n";
    } else {
      cout << "float " << s.substr(0, pos) << " 0"
           << s.substr(pos, s.size() - pos) << "\n";
    }
  }

  return 0;
}