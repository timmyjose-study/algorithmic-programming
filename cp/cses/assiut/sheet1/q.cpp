#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  double x, y;

  cin >> x >> y;

  if (fabs(x - 0.0) < EPS && fabs(y - 0.0) < EPS) {
    cout << "Origem\n";
  } else if (fabs(x - 0.0) < EPS) {
    cout << "Eixo Y\n";
  } else if (fabs(y - 0.0) < EPS) {
    cout << "Eixo X\n";
  } else if (x >= 0 && y >= 0) {
    cout << "Q1"
         << "\n";
  } else if (x >= 0 && y <= 0) {
    cout << "Q4"
         << "\n";
  } else if (x <= 0 && y >= 0) {
    cout << "Q2"
         << "\n";
  } else {
    cout << "Q3"
         << "\n";
  }

  return 0;
}