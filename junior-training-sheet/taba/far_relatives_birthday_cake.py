def main():
    n = int(input())
    cake = []
    for _ in range(n):
        cake.append(list(input()))

    sol = 0
    for i in range(n):
        m = 0
        p = 0
        for j in range(n):
            if cake[i][j] == 'C':
                m += 1
        sol += m * (m - 1) // 2

        for j in range(n):
            if cake[j][i] == 'C':
                p += 1
        sol += p * (p - 1) // 2

    print(sol)


if __name__ == "__main__":
    main()