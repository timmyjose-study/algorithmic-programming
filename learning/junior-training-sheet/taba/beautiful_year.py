def main():
    y = int(input())
    y += 1

    while True:
        yy = str(y)
        s = set()
        for c in yy:
            s.add(c)

        if len(s) == 4:
            print(yy)
            return
        y += 1


if __name__ == "__main__":
    main()