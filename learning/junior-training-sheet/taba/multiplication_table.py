def main():
    [n, k] = list(map(int, input().split()))

    c = 0
    for i in range(1, n + 1):
        if k % i == 0 and (k // i) <= n:
            c += 1

    print(c)


if __name__ == "__main__":
    main()



