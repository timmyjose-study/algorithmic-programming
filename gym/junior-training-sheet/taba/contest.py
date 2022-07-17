def main():
    [a, b, c, d] = list(map(int, input().split()))

    ms = max(3 * a // 10, a - (a // 250) * c)
    vs = max(3 * b // 10, b - (b // 250) * d)

    if ms == vs:
        print("Tie")
    elif ms > vs:
        print("Misha")
    else:
        print("Vasya")


if __name__ == "__main__":
    main()

