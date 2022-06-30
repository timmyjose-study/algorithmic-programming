def main():
    n = int(input())

    ns = list(map(int, input().split()))
    ns.sort()

    sol = 0
    for i in range(1, n - 1):
        valid = 0
        for j in range(i - 1, -1, -1):
            if ns[j] < ns[i]:
                valid += 1
                break

        if valid != 1:
            continue

        for j in range(i + 1, n):
            if ns[j] > ns[i]:
                valid += 1
                break

        if valid != 2:
            continue
        sol += 1

    print(sol)


if __name__ == "__main__":
    main()



