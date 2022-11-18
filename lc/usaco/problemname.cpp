#include <algorithm>
#include <cmath>
#include <fstream>
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

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  ifstream fin("problemname.in");
  ofstream fout("problemname.out");

  fout << "Hi\n";

  return 0;
}