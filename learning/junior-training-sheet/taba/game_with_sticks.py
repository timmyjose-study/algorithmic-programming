def main():
    [n, m] = list(map(int, input().split()))

    move = "Malvika"
    while n != 0 and m != 0:
        n -= 1
        m -= 1
        if move == "Malvika":
            move = "Akshat"
        else:
            move = "Malvika"

    print(move)


if __name__ == "__main__":
    main()

