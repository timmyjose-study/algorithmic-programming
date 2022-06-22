def main():
    s = input().strip()
    t = input().strip()

    if s[::-1] == t:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()