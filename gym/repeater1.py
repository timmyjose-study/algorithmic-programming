class RepeaterIterator:
    def __init__(self, source):
        self.source = source

    def __next__(self):
        return self.source.value

class Repeater:
    def __init__(self, value):
        self.value = value

    def __iter__(self):
        return RepeaterIterator(self)

def main():
    repeater = Repeater("Hello")
    #iter = repeater.__iter__()
    #while True:
    #    print(iter.__next__())
    for item in repeater:
        print(item)

if __name__ == "__main__":
    main()