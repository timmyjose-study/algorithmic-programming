from sys import stdin

class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(10)]
        self.terminal = False

    def set_terminal(self):
        self.terminal = True

    def is_terminal(self):
        return self.terminal

    def has_child(self, idx):
        return self.children[idx] != None

    def set_child(self, idx):
        self.children[idx] = TrieNode()
        return self.children[idx]

    def get_child(self, idx):
        return self.children[idx]


def readint():
    return int(stdin.readline())

def main():
    tt = readint()
    for _ in range(tt):
        t = TrieNode()
        n = readint()
        valid = True
        for _ in range(n):
            s = stdin.readline().strip()
            tcopy = t
            i = 0
            while i < len(s):
                idx = ord(s[i]) - ord('0')
                if tcopy.has_child(idx):
                    tcopy = tcopy.get_child(idx)
                else:
                    tcopy = tcopy.set_child(idx)
                if tcopy.is_terminal():
                    break
                i += 1
            if i < len(s) - 1:
                valid = False
                break
            tcopy.set_terminal()
        if valid:
            print("YES")
        else:
            print("NO")


if __name__ == "__main__":
    main()




