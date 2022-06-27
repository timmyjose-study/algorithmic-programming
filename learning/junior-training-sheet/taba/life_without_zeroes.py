def remove_zeroes(n):
    s = []
    while n != 0:
        d = n % 10
        if d != 0:
            s.append(d)
        n //= 10

    r = 0
    for i in range(len(s) - 1, -1, -1):
        r = 10 * r + s[i]
    return r



def main():
    n = int(input())
    m = int(input())
    s = n + m

    if remove_zeroes(n) + remove_zeroes(m) == remove_zeroes(s):
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()



