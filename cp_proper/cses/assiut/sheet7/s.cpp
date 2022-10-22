#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

double average(const vector<int> &a, int i, int n, long long sum) {
  if (i == n) {
    return (double)sum / (double)n;
  }

  return average(a, i + 1, n, sum + (long long)a[i]);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << fixed << setprecision(6) << average(a, 0, n, 0LL) << "\n";

  return 0;
}