class BoundedRepeaterIterator:
    def __init__(self, source):
        self.source = source
        self.curr_count = 0

    def __next__(self):
        if self.curr_count >= self.source.count:
            raise StopIteration
        self.curr_count += 1
        return self.source.value


class BoundedRepeater:
    def __init__(self, value, count):
        self.value = value
        self.count = count

    def __iter__(self):
        return BoundedRepeaterIterator(self)


def main():
    repeater = BoundedRepeater("Hello", 5)
    for item in repeater:
        print(item)


if __name__ == "__main__":
    main()



