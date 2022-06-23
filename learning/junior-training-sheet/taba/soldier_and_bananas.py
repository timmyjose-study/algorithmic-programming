def main():
    [k, n, w] = list(map(int, input().split()))
    d = (w * (w + 1) // 2) * k - n

    if d <= 0:
        print(0)
    else:
        print(d)


if __name__ == "__main__":
    main()