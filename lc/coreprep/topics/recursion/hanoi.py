def hanoi(n, frompeg, topeg, auxpeg):
    assert n >= 1

    if n == 1:
        print(f"Move disk {n} from {frompeg} to {topeg}")
    else:
        hanoi(n - 1, frompeg, auxpeg, topeg)
        print(f"Move disk {n} from {frompeg} to {topeg}")
        hanoi(n - 1, auxpeg, topeg, frompeg)

def main():
    while True:
        try:
            n = int(input())
            hanoi(n, 'A', 'C', 'B')
        except AssertionError:
            print("invalid input")
        except EOFError:
            break

if __name__ == "__main__":
    main()