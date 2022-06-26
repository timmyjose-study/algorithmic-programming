def main():
    n = int(input())
    nw = n // 7
    nd = n % 7

    mn = nw * 2
    mx = nw * 2 + min(nd, 2)

    if nd > 5:
        mn += 1

    print(mn, mx)


if __name__ == "__main__":
    main()
