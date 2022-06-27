def main():
    [n, m] = list(map(int, input().split()))

    ms = []
    for _ in range(n):
        ms.append(list(map(int, list(input()))))

    sol = [False for _ in range(n)]

    for j in range(m):
        mx = -1
        for i in range(n):
            if ms[i][j] > mx:
                mx = ms[i][j]

        for i in range(n):
            if ms[i][j] == mx:
                sol[i] = True


    c = 0
    for s in sol:
        if s:
            c += 1
    print(c)


if __name__ == "__main__":
    main()



