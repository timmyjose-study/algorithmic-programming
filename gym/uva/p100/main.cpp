#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int from, to;

  while (cin >> from && cin >> to) {
    bool was_flipped = false;

    if (from > to) {
      int t = to;
      to = from;
      from = t;
      was_flipped = true;
    }

    int max_cycle = -1;

    for (int curr = from; curr <= to; curr++) {
      int curr_cycle = 0;
      int elem = curr;
      while (elem != 1) {
        curr_cycle++;
        if (elem % 2 == 0) {
          elem /= 2;
        } else {
          elem = 3 * elem + 1;
        }
      }
      curr_cycle++;

      max_cycle = max(max_cycle, curr_cycle);
    }

    if (was_flipped) {
      cout << to << " " << from << " " << max_cycle << "\n";
    } else {
      cout << from << " " << to << " " << max_cycle << "\n";
    }
  }

  return 0;
}