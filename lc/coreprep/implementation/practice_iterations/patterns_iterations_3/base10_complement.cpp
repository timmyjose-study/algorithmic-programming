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

// O(b) / O(1)
unsigned complement(unsigned n) {
  int nb = 0;
  unsigned m = n;
  while (m) {
    nb++;
    m >>= 1;
  }

  return n ^ ((unsigned)pow(2, nb) - 1);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  unsigned n;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cout << complement(n) << "\n";
  }

  return 0;
}