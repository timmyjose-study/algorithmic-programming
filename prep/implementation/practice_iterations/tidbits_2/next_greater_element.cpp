#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    vector<int> res(n, -1);

    vector<int> st;
    for (int i = 0; i < n; i++) {
      while (!st.empty() && (a[st.back()] < a[i])) {
        res[st.back()] = a[i];
        st.pop_back();
      }
      st.push_back(i);
    }

    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}