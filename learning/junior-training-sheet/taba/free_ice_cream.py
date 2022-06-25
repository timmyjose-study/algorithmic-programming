def main():
    [n, x] = list(map(int, input().split()))
    d = 0

    for _ in range(n):
        s = input().strip().split()
        if s[0] == '+':
            x += int(s[1])
        else:
            if x >= int(s[1]):
                x -= int(s[1])
            else:
                d += 1

    print(x, d)


if __name__ == "__main__":
    main()