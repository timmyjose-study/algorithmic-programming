def main():
    ds = [4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777]

    n = int(input())
    for d in ds:
        if n % d == 0:
            print("YES")
            return 
    print("NO")


if __name__ == "__main__":
    main()



