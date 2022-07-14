# https://news.ycombinator.com/item?id=20727126#20728001
from sys import stdin
from collections import Counter

def readint():
    return int(stdin.readline())

def readline():
    return stdin.readline().strip()

def main():
    n = readint()
    s = readline()

    if n > len(s):
        print(0)
    else:
        c = Counter()
        for i in range(0, len(s) - n + 1):
            t = s[i:i+n]
            c[t] += 1

        for s, c in sorted(c.items()):
            print(f"{c}x{s}", end = ' ')
        print()


if __name__ == "__main__":
    main()




