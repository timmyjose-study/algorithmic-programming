# O(n) time, O(1) space
def fibonacci(n):
    if n <= 1:
        return n
    
    a, b = 0, 1
    n -= 2
    while n >= 0:
        t = a
        a = b
        b = t + b
        n -= 1
    return b

def main():
    while True:
        try:
            n = int(input())
            print(f"fibonacci({n}) = {fibonacci(n)}")
        except EOFError:
            break

if __name__ == "__main__":
    main()