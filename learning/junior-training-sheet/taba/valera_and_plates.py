def main():
    [_, b, p] = list(map(int, input().split()))
    ds = list(map(int, input().split()))

    sol = 0
    for d in ds:
        if d == 2:
            if p != 0:
                p -= 1
            elif b != 0:
                b -= 1
            else:
                sol += 1
        else:
            if b != 0:
                b -= 1
            else:
                sol += 1

    print(sol)


if __name__ == "__main__":
    main()

