def main():
    [n, m] = list(map(int, input().split()))
    flag = []
    for _ in range(n):
        flag.append(list(input()))

    for i in range(n):
        c = flag[i][0]
        for j in range(1, m):
            if flag[i][j] != c:
                print("NO")
                return

    for i in range(n - 1):
        if flag[i][0] == flag[i + 1][0]:
            print("NO")
            return

    print("YES")


if __name__ == "__main__":
    main()