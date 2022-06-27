def main():
    n = int(input())
    a = list(map(int, input().split()))

    min_dist = a[0]
    min_dist_idx = 0
    for i in range(n):
        if a[i] < min_dist:
            min_dist = a[i]
            min_dist_idx = i

    sol = 0
    for d in a:
        if d == min_dist:
            sol += 1

    if sol != 1:
        print("Still Rozdil")
    else:
        print(min_dist_idx + 1)


if __name__ == "__main__":
    main()



