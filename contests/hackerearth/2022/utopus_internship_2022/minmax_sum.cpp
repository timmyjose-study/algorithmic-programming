#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

vector<long long> solve(int N, vector<int> A) {
  vector<long long> maxes, mins;
  long long maxsum = 0LL, minsum = 0LL;

  for (int i = 0; i < N; i++) {
    if (maxsum + A[i] > maxsum) {
      maxsum += A[i];
    }

    if (minsum + A[i] < minsum) {
      minsum += A[i];
    }

    maxes.push_back(maxsum);
    mins.push_back(minsum);
  }

  vector<long long> res(N);
  for (int i = 0; i < N; i++) {
    res[i] = maxes[i] + mins[i];
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = solve(n, a);
    for (auto r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}