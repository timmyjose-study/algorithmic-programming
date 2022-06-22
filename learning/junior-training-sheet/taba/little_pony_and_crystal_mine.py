def main():
    n = int(input())

    for i in range(0, n // 2):
        s = ["D" for _ in range(n)]

        for j in range(0, n // 2 - i):
            s[j] = "*"

        for j in range(n // 2 + i + 1, n):
            s[j] = "*"
        print("".join(s))

    for i in range(n // 2, -1, -1):
        s = ["D" for _ in range(n)]

        for j in range(0, n // 2 - i):
            s[j] = "*"

        for j in range(n // 2 + i + 1, n):
            s[j] = "*"

        print("".join(s))


if __name__ == "__main__":
    main()