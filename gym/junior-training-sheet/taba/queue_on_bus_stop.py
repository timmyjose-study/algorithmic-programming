def main():
    [_, k] = list(map(int, input().split()))
    a = list(map(int, input().split()))

    sol = 0
    while len(a) != 0:
        s = a[0]
        del a[0]

        if s <= k:
            sol += 1
            while len(a) > 0 and (s + a[0] <= k):
                s += a[0]
                del a[0]
        else:
            sol += 1
            a.insert(0, s % k)

    print(sol)


if __name__ == "__main__":
    main()


