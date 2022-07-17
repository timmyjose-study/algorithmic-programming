def main():
    s = set()
    s.add('4')
    s.add('7')

    ns = input()
    lc = 0
    for c in ns:
        if c in s:
            lc += 1

    t = str(lc)
    for c in t:
        if c not in s:
            print("NO")
            return
    print("YES")


if __name__ == "__main__":
    main()