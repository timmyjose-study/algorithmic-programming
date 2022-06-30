def main():
    [n, k, l, c, d, p, nl, np] = list(map(int, input().split()))
    print(min(c * d, min(p // np, (k * l) // nl)) // n)


if __name__ == "__main__":
    main()