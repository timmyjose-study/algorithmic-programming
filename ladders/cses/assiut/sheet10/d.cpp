#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string a, b, aa, bb;
  cin >> a >> b;

  aa = a;
  bb = b;

  sort(aa.begin(), aa.end());
  sort(bb.begin(), bb.end());

  if (aa != bb) {
    cout << "NO\n";
    return 0;
  }

  if (a.size() != b.size()) {
    cout << "NO\n";
    return 0;
  }

  int inv_cnt = 0;
  for (int i = 0; i < a.size(); i++) {
    if (a[i] != b[i]) {
      inv_cnt++;
    }
  }

  cout << (inv_cnt == 2 ? "YES" : "NO") << "\n";

  return 0;
}