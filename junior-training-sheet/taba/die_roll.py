def gcd(n, m):
    if m == 0:
        return n
    return gcd(m, n % m)


def main():
    [y, w] = list(map(int, input().split()))
    s = 6 - max(y, w) + 1
    g = gcd(s, 6)
    print(s // g, '/', 6 // g, sep='')


if __name__ == "__main__":
    main()