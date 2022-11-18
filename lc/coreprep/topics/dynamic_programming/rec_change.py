from collections import deque
from math import sqrt, inf

def min_change(a, n, cs):
    if a == 0:
        return 0

    cnt = inf
    for c in cs:
        if c <= a:
            cnt = min(cnt, 1 + min_change(a - c, n, cs))
    return cnt

def main():
    tt = int(input())

    for _ in range(tt):
        a = int(input())
        n = int(input())
        cs = list(map(int, input().strip().split()))

        possible = False
        for c in cs:
            if a % c == 0:
                possible = True
                break
        
        if not possible:
            print("inf")
            return

        print(min_change(a, n, cs))

if __name__ == "__main__":
    main()

