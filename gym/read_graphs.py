from collections import defaultdict

def main():
    n = int(input())
    g = defaultdict(dict) # backing type
    for _ in range(n):
        u, v, w = input().split()
        g[u][v] = int(w)

    print(g)

if __name__ == "__main__":
    main()