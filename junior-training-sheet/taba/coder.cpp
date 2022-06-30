#include <iostream>
#include <string>
#include <vector>

int main() {
  int n;
  std::cin >> n;

  std::vector<std::vector<char>> sol;
  for (int i = 0; i < n; i++) {
    std::vector<char> v;
    for (int j = 0; j < n; j++) {
      v.push_back('C');
    }
    sol.push_back(v);
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (sol[i][j] == 'C') {
        if (j > 0 && sol[i][j - 1] == 'C') {
          sol[i][j - 1] = '.';
        }

        if (j < n - 1 && sol[i][j + 1] == 'C') {
          sol[i][j + 1] = '.';
        }

        if (i > 0 && sol[i - 1][j] == 'C') {
          sol[i - 1][j] = '.';
        }

        if (i < n - 1 && sol[i + 1][j] == 'C') {
          sol[i + 1][j] = '.';
        }
      }
    }
  }

  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (sol[i][j] == 'C') {
        count++;
      }
    }
  }

  std::cout << count << std::endl;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      std::cout << sol[i][j];
    }
    std::cout << std::endl;
  }

  return 0;
}