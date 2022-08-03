def bin2dec(b):
    d = 0
    m = 1

    for i in range(len(b) - 1, -1, -1):
        d += m * int(b[i])
        m <<= 1
    return d