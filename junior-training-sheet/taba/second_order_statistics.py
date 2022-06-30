def main():
    _ = int(input())
    ns = list(map(int, input().split()))

    s = set(ns)
    ns = list(s)
    ns.sort()

    if len(ns) > 1:
        print(ns[1])
    else:
        print("NO")


if __name__ == "__main__":
    main()