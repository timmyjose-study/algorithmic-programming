#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int min(const vector<int> &a) {
  int min_val = a[0];
  for (int e : a) {
    if (e < min_val) {
      min_val = e;
    }
  }

  return min_val;
}

int max(const vector<int> &a) {
  int max_val = a[0];
  for (int e : a) {
    if (e > max_val) {
      max_val = e;
    }
  }
  return max_val;
}

int count_primes(const vector<int> &a) {
  auto is_prime = [](int n) {
    if (n == 1) {
      return false;
    }

    for (int i = 2; i <= round(sqrt(n)); i++) {
      if (!(n % i)) {
        return false;
      }
    }
    return true;
  };

  int pc = 0;
  for (int e : a) {
    if (is_prime(e)) {
      pc++;
    }
  }
  return pc;
}

int count_palindromes(const vector<int> &a) {
  auto is_palindrome = [](int n) {
    string s = to_string(n);
    for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
      if (s[i] != s[j]) {
        return false;
      }
    }
    return true;
  };

  int pc = 0;
  for (int e : a) {
    if (is_palindrome(e)) {
      pc++;
    }
  }
  return pc;
}

int max_divisors(const vector<int> &a) {
  auto ndivisors = [](int n) {
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (!(n % i)) {
        cnt++;
      }
    }
    return cnt;
  };

  int maxd = ndivisors(a[0]), sol = a[0];
  for (int e : a) {
    int d = ndivisors(e);
    if (d > maxd) {
      maxd = d;
      sol = e;
    } else if (d == maxd) {
      sol = e > sol ? e : sol;
    }
  }

  return sol;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << "The maximum number : " << max(a) << "\n";
  cout << "The minimum number : " << min(a) << "\n";
  cout << "The number of prime numbers : " << count_primes(a) << "\n";
  cout << "The number of palindrome numbers : " << count_palindromes(a) << "\n";
  cout << "The number that has the maximum number of divisors : "
       << max_divisors(a) << "\n";

  return 0;
}