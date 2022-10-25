class InvalidInputError(Exception):
    pass

def factorial(n):
    if n < 0:
        raise InvalidInputError

    if n == 0:
        return 1
    return n * factorial(n-1)

def factorial_iter(n):
    if n < 0:
        raise InvalidInputError

    f = 1
    for i in range(2, n + 1):
        f *= i
    return f

def main():
    while True:
        try:
            n = int(input())
            print(f"factorial({n}) = {factorial(n)}, {factorial_iter(n)}")
        except InvalidInputError:
            print("invalid input")
        except EOFError:
         break

if __name__ == "__main__":
    main()