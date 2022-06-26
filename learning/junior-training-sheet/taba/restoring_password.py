def main():
    p = input().strip()
    ns = dict()
    for i in range(10):
        ns[input().strip()] = i

    i = 0
    while i < len(p):
        print(ns[p[i:i+10]], end='')
        i += 10
    print()


if __name__ == "__main__":
    main()

