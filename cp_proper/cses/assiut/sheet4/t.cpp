#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto handle_param = [](const string &s, const string &param) {
    auto start_pos = s.find(param);
    auto key_pos = s.find("&", start_pos + 1);
    if (key_pos != s.size()) {
      cout << param << ": "
           << s.substr(start_pos + param.size() + 1,
                       key_pos - (start_pos + param.size() + 1));
    } else {
      cout << param << ": "
           << s.substr(start_pos + param.size() + 1,
                       s.size() - (start_pos + param.size() + 1));
    }
    cout << "\n";
  };

  string s;
  cin >> s;

  const vector<string> params = {"username", "pwd", "profile", "role", "key"};
  for (auto &param : params) {
    handle_param(s, param);
  }

  return 0;
}