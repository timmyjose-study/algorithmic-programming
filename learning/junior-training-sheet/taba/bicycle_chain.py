def main():
    _ = int(input())
    ns = list(map(int, input().split()))
    _ = int(input())
    ms = list(map(int, input().split()))

    gs = []
    for a in ns:
        for b in ms:
            if b % a == 0:
                gs.append(b // a)

    gs = sorted(gs, reverse = True)

    sol = 0
    for g in gs:
        if g == gs[0]:
            sol += 1
    print(sol)


if __name__ == "__main__":
    main()



