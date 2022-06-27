from functools import reduce

def main():
    [n, s] = list(map(int, input().split()))

    a = []
    for _ in range(n):
        a.append(list(map(int, input().split())))

    a = sorted(a, key = lambda p: p[0], reverse = True)

    sol = 0
    for i in range(n):
        travel = s - a[i][0]
        sol += travel

        a[i][1] = max(0, a[i][1] - travel)
        if (a[i][1] > 0):
            sol += a[i][1]

        for j in range(i + 1, n):
            a[j][1] = max(0, a[j][1] - travel)
            a[j][1] = max(0, a[j][1] - a[i][1])
        s -= travel

    sol += a[n-1][0];
    print(sol)


if __name__ == "__main__":
    main()


