def main():
    n = int(input())
    bus = []

    done = False
    for _ in range(n):
        row = list(input().strip())
        if not done:
            if row[0] == 'O' and row[1] == 'O':
                row[0] = '+'
                row[1] = '+'
                done = True
            elif row[3] == 'O' and row[4] == 'O':
                row[3] = '+'
                row[4] = '+'
                done = True
        bus.append("".join(row))

    if done:
        print("YES")
        for r in bus:
            print(r)
    else:
        print("NO")


if __name__ == "__main__":
    main()