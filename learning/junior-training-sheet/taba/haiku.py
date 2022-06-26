def main():
    v = set(['a', 'e', 'i', 'o', 'u'])

    ss = []
    for _ in range(3):
        ss.append(input().strip())

    cs = [0 for _ in range(3)]

    for i in range(3):
        c = 0
        for e in ss[i]:
            if e in v:
                c += 1
        cs[i] = c

    if cs[0] == 5 and cs[1] == 7 and cs[2] == 5:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()

