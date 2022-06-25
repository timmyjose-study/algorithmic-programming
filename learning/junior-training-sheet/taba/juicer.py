def main():
    [_, b, d] = list(map(int, input().split()))
    os = list(map(int, input().split()))

    c = 0
    w = 0
    for o in os:
        if o <= b:
            w += o
            if w > d:
                c += 1
                w = 0

    print(c)


if __name__ == "__main__":
    main()