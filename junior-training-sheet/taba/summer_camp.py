def main():
    n = int(input())
    s = ""
    for i in range(1, 1001):
        s += str(i)

    print(s[n - 1])


if __name__ == "__main__":
    main()