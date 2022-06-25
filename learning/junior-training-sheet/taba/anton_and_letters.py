def main():
    ss = input()[1:]
    ss = ss[:len(ss) - 1].split(',')

    u = set()
    for s in ss:
        if len(s) > 0:
            u.add(s.strip())

    print(len(u))


if __name__ == "__main__":
    main()