def mult(a, b):
    assert a >= 0
    assert b >= 0

    if b == 0:
        return 0
    return mult(a, b - 1) + a

def mult_iter(a, b):
    assert a >= 0
    assert b >= 0

    p = 0
    for _ in range(0, b):
        p += a
    return p

def main():
    while True:
        try:
            a, b = map(int, input().split())
            print(f"mult({a}, {b}) = {mult(a, b)}, {mult_iter(a, b)}")
        except AssertionError:
            print("invalid input")
        except EOFError:
            break

if __name__ == "__main__":
    main()