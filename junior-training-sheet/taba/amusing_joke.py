def main():
    s = list(input().strip())
    t = list(input().strip())
    u = list(input().strip())

    if len(s) + len(t) != len(u):
        print("NO")
        return

    d1 = dict()
    d2 = dict()

    for k in s:
        if k not in d1:
            d1[k] = 0
        else:
            d1[k] += 1

    for k in t:
        if k not in d1:
            d1[k] = 0
        else:
            d1[k] += 1

    for k in u:
        if k not in d2:
            d2[k] = 0
        else:
            d2[k] += 1

    for k, v in d1.items():
        if k not in d2 or v != d2[k]:
            print("NO")
            return

    print("YES")


if __name__ == "__main__":
    main()