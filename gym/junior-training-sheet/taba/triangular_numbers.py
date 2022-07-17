def main():
    ns = [i * (i + 1) // 2 for i in range(1, 501)]
    n = int(input())
    if n in ns:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()