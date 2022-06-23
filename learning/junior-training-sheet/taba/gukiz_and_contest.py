def main():
    n = int(input())
    ns = list(map(int, input().split()))

    d = {}
    ms = sorted(ns, reverse=True)
    i = 0
    while i < n:
        k = ms[i]
        c = i
        while c < n and ms[c] == k:
            c += 1
        d[k] = i + 1
        i = c

    for n in ns:
        print(d[n], end=' ')
    print()


if __name__ == "__main__":
    main()