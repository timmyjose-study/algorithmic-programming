def rabin_karp(s, t):
    m = 53
    p = int(1e9 + 9)

    slen, tlen = len(s), len(t)
    ppow = [0 for _ in range(max(slen, tlen))]

    ppow[0] = 1
    for i in range(1, len(ppow)):
        ppow[i] = (ppow[i-1] * p) % m

    shash = 0
    for i in range(slen):
        shash = (shash + (ord(s[i]) - ord(' ') + 1) * ppow[i]) % m

    thashes = [0 for _ in range(tlen + 1)]
    for i in range(tlen):
        thashes[i + 1] = (thashes[i] + (ord(t[i]) - ord(' ') + 1) * ppow[i]) % m

    occurrences = []
    for i in range(tlen - slen + 1):
        curr_hash = (thashes[i+slen] + m - thashes[i]) % m
        if curr_hash == shash * ppow[i] % m:
            occurrences.append(i)
    return occurrences

def main():
    n = int(input())

    for _ in range(n):
        s = input().strip()
        t = input().strip()

        ps = rabin_karp(s, t)
        print(f"s = {s}, t = {t}")
        if len(ps) == 0:
            print(-1)
        else:
            print(len(ps))
            for p in ps:
                print(p, end= " ")
            print()

if __name__ == "__main__":
    main()