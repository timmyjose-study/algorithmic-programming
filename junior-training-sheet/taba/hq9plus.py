def main():
    s = list(input().strip())
    for c in s:
        if c in ['H', 'Q', '9']:
            print("YES")
            return
    print("NO")


if __name__ == "__main__":
    main()

