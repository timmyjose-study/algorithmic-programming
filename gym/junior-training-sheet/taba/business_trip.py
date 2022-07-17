def main():
    k = int(input())
    ns = list(map(int, input().split()))

    ns = sorted(ns, reverse = True)
    g = 0
    sol = 0
    for m in ns:
        if g >= k:
            break

        sol += 1
        g += m

    if g < k:
        print(-1)
    else:
        print(sol)


if __name__ == "__main__":
    main()