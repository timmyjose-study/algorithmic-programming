#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  const string key =
      "PgEfTYaWGHjDAmxQqFLRpCJBownyUKZXkbvzIdshurMilNSVOtec#@_!=.+-*/";
  const string orig =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  map<char, char> o2k;
  map<char, char> k2o;

  int len = key.size();
  for (int i = 0; i < len; i++) {
    o2k[orig[i]] = key[i];
    k2o[key[i]] = orig[i];
  }

  int q;
  cin >> q;

  string s, sol = "";
  cin >> s;

  switch (q) {
  case 1:
    for (char c : s) {
      sol += o2k[c];
    }
    break;

  default:
    for (char c : s) {
      sol += k2o[c];
    }
  }

  cout << sol << "\n";

  return 0;
}