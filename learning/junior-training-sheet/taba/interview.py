def main():
    n = int(input())
    xs = list(map(int, input().split()))
    ys = list(map(int, input().split()))

    mx = -12345
    for i in range(n):
        v1 = xs[i]
        for j in range(i + 1, n):
            v1 |= xs[j]

        v2 = ys[i]
        for k in range(i + 1, n):
            v2 |= ys[k]

        mx = max(mx, v1 + v2)
    print(mx)


if __name__ == "__main__":
    main()



