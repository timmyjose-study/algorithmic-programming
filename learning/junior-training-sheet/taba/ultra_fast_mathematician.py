def main():
    s = input().strip()
    t = input().strip()

    u = ""
    for i in range(len(s)):
        if s[i] != t[i]:
            u += "1"
        else:
            u += "0"

    print(u)


if __name__ == "__main__":
    main()