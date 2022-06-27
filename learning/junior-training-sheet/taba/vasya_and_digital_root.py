def main():
    [n, d] = list(map(int, input().split()))
    
    if n == 1:
        print(d)
    else:
        if d == 0:
            print("No solution")
        else:
            s = '1' + '0' * (n - 2) + str(d - 1)
            print(s)


if __name__ == "__main__":
    main()