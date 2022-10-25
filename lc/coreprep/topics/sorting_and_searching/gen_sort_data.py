import sys
from random import randint

def gen_data(n, mn, mx):
    s = str(n) + "\n"
    for _ in range(n):
        s += str(randint(mn, mx))
        s += " "

    with open("sort.in", "w") as f:
        f.write(s)
        f.write("\n")

def main():
    if len(sys.argv) != 4:
        print("Usage: gen_sort_data <num-elems> <min-val> <max-val>")
        exit(0)
    [n, mn, mx] = map(int, sys.argv[1:])
    gen_data(n, mn, mx)

if __name__ == "__main__":
    main()
