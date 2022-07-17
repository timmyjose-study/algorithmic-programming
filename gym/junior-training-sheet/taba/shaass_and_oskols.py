def main():
    n = int(input())
    bs = list(map(int, input().split()))

    m = int(input())
    for _ in range(m):
        [w, b] = list(map(int, input().split()))
        w -= 1
        b -= 1

        if w > 0:
            bs[w - 1] += b

        if w < n - 1:
            bs[w + 1] += bs[w] - b - 1

        bs[w] = 0

    for b in bs:
        print(b)


if __name__ == "__main__":
    main()