from functools import reduce

def main():
    ns = list(map(int, input().split()))
    n = len(ns)
    s = reduce(lambda x, y: x + y, ns)

    if s == 0:
        print(-1)
    elif s % n == 0:
        print(s // n)
    else:
        print(-1)


if __name__ == "__main__":
    main()



