from sys import stdin
from collections import Counter

def main():
    n = int(stdin.readline())

    vs = "aeiou"
    cs = "bcdfghjklmnpqrstvwxyz"

    for _ in range(n):
        s = stdin.readline().strip()
        sol = ""
        d = Counter()
        for c in s:
            d[c] += 1

            if c in vs:
                e = vs.find(c)
                sol += cs[((d[c] - 1) * 5 + e) % len(cs)]
            else:
                e = cs.find(c)
                sol += vs[((d[c] - 1) * 21 + e) % len(vs)]

        print(sol)


if __name__ == "__main__":
    main()