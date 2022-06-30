def main():
    n = int(input())
    s = list(map(int, list(input())))
    t = list(map(int, list(input())))

    sol = 0
    for i in range(n):
        sol += min(min(10 - s[i] + t[i], 10 - t[i] + s[i]), abs(s[i] - t[i]))
    print(sol)


if __name__ == "__main__":
    main()