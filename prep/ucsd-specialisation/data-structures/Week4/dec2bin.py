def dec2bin(d):
    b = []

    while d != 0:
        b.append(d % 2)
        d >>= 1

    if len(b) < 8:
        for _ in range(8-len(b)):
            b.append("0")

    i = 0
    j = len(b) - 1
    while i < j:
        t = b[i]
        b[i] = b[j]
        b[j] = t
        i += 1
        j -= 1

    return "".join(map(str, b))