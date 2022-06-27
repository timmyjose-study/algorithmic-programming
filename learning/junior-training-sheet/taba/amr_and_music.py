def main():
    [n, k] = list(map(int, input().split()))
    ns = list(map(int, input().split()))
    for i in range(n):
        ns[i] = [ns[i], i + 1]

    ns = sorted(ns, key = lambda p: p[0])

    s = 0
    sol = []
    for e in ns:
        if s+ e[0] <= k:
            s += e[0]
            sol.append(e[1])

    if len(sol) > 0:
        print(len(sol))
        for s in sol:
            print(s, end= ' ')
        print()
    else:
        print(0)

if __name__ == "__main__":
    main()



