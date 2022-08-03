def string_hash(s):
    p = 53
    m = int(1e9 + 9)
    ppow = 1

    hash_val = 0
    for i in range(len(s)):
        hash_val = (hash_val + (ord(s[i]) - ord(' ') + 1) * ppow) % m
        ppow = (ppow * p) % m
    return hash_val

def main():
    n = int(input())
    
    for _ in range(n):
        s = input().strip()
        print(f"hash({s}) = {string_hash(s)}")

if __name__ == "__main__":
    main()
