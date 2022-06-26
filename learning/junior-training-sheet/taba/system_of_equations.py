def main():
    [n, m] = list(map(int, input().split()))

    sol = 0
    for i in range(1000):
        for j in range(1000):
            if (i * i + j == n) and (i + j * j == m):
                sol += 1
    print(sol)


if __name__ == "__main__":
    main()

