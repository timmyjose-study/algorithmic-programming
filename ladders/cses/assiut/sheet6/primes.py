from math import sqrt

def is_prime(n):
    lim = round(sqrt(n))
    for d in range(2, lim + 1):
        if n % d == 0:
            return False
    return True

def main():
    ps = []
    for n in range(1000000, 2000001):
        if is_prime(n):
            print(n, end =  ' ')
            ps.append(n)
    print(len(ps))

if __name__ == "__main__":
    main()