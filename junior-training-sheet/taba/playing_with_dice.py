def main():
    [a, b] = list(map(int, input().split()))
    f = 0
    d = 0
    s = 0

    for i in range(1, 7):
        if abs(a - i) < abs(b - i):
            f += 1
        elif abs(a - i) == abs(b - i):
            d += 1
        else:
            s += 1

    print(f, d, s)


if __name__ == "__main__":
    main()