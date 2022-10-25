#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int move_ways(int s, int e) {
  if (s > e) {
    return 0;
  }

  if (s == e) {
    return 1;
  }

  return move_ways(s + 1, e) + move_ways(s + 2, e) + move_ways(s + 3, e);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int s, e;
  cin >> s >> e;
  cout << move_ways(s, e) << "\n";

  return 0;
}