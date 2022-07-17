def main():
    n = int(input())
    ns = list(enumerate(map(int, input().split())))
    ns = sorted(ns, key=lambda t: t[1])

    for i in range(n // 2):
        (p, _) = ns[i]
        (q, _) = ns[n - i - 1]
        print(p + 1, q + 1)


if __name__ == "__main__":
    main()