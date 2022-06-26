def main():
    [n, k] = list(map(int, input().split()))

    d = 0
    while n != 0:
        n -= 1
        d += 1

        if (d % k) == 0:
            n += 1

    print(d)



if __name__ == "__main__":
    main()

