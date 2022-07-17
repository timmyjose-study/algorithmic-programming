def main():
    n = int(input())
    sol = [["C" for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if sol[i][j] == "C":
                if j > 0 and sol[i][j - 1] == "C":
                    sol[i][j - 1] = "."

                if j < n - 1 and sol[i][j + 1] == "C":
                    sol[i][j + 1] = "."

                if i > 0 and sol[i - 1][j] == "C":
                    sol[i - 1][j] = "."

                if i < n - 1 and sol[i + 1][j] == "C":
                    sol[i + 1][j] = "."

    count = 0
    for i in range(n):
        for j in range(n):
            if sol[i][j] == "C":
                count += 1

    print(count)
    for i in range(n):
        for j in range(n):
            print(sol[i][j], end='')
        print()


if __name__ == "__main__":
    main()