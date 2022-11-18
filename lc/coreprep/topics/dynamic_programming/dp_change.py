from collections import deque
from math import sqrt, inf

def min_change(a, n, cs):
    dp = [inf for _ in range(a + 1)]
    dp[0] = 0

    for i in range(1, a + 1):
        for c in cs:
            if c <= i:
                dp[i] = min(dp[i], 1 + dp[i - c])
    return dp[a]

def main():
    tt = int(input())

    for _ in range(tt):
        a = int(input())
        n = int(input())
        cs = list(map(int, input().strip().split()))

        print(min_change(a, n, cs))

if __name__ == "__main__":
    main()
