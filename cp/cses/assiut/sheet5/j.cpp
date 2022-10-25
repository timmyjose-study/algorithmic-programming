#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

double average(const vector<double> &a, int n) {
  double sum = 0.0;
  for (int i = 0; i < n; i++) {
    sum += a[i];
  }

  return sum / (double)n;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<double> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << fixed << setprecision(6) << average(a, n) << "\n";

  return 0;
}