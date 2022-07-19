#include "vectorfunctions.h"
#include <vector>

using namespace std;

void backwards(vector<int> &v) {
  for (int i = 0, j = v.size() - 1; i < j; i++, j--) {
    int t = v[i];
    v[i] = v[j];
    v[j] = t;
  }
}

vector<int> everyOther(const vector<int> &v) {
  vector<int> r;
  for (int i = 0; i < v.size(); i += 2) {
    r.push_back(v[i]);
  }

  return r;
}

int smallest(const vector<int> &v) {
  int s = v[0];
  for (int i = 1; i < v.size(); i++) {
    if (v[i] < s) {
      s = v[i];
    }
  }

  return s;
}

int sum(const vector<int> &v) {
  int s = 0;
  for (auto e : v) {
    s += e;
  }

  return s;
}

int veryOdd(const vector<int> &v) {
  int cnt = 0;
  for (int i = 0; i < v.size(); i++) {
    if ((i % 2 == 1) && (v[i] % 2 == 1)) {
      cnt++;
    }
  }

  return cnt;
}