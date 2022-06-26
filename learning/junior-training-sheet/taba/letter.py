def main():
    [n, m] = list(map(int, input().split()))
    a = []
    for _ in range(n):
        a.append(list(input()))

    top = 12345
    bottom = -12345
    left = 12345
    right = -12345
    for i in range(n):
        for j in range(m):
            if a[i][j] == '*':
                top = min(top, i)
                right = max(right, j)
                bottom = max(bottom, i)
                left = min(left, j)

    for i in range(top, bottom + 1):
        for j in range(left, right + 1):
            print(a[i][j], end = '')
        print()

if __name__ == "__main__":
    main()

