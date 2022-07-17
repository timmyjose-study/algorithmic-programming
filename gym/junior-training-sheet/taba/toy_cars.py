def main():
    n = int(input())
    cs = []
    for _ in range(n):
        cs.append(list(map(int, input().split())))

    sol = 0
    vs = []
    for idx, c in enumerate(cs):
        valid = True
        for r in c:
            if r in [1, 3]:
                valid = False
                break
        if valid:
            sol += 1
            vs.append(idx + 1)


    if sol == 0:
        print(sol)
    else:
        print(sol)
        for v in vs:
            print(v, end= ' ')
        print()



if __name__ == "__main__":
    main()

