class Repeater:
    def __init__(self, value):
        self.value = value

    def __iter__(self):
        return self

    def __next__(self):
        return self.value

def main():
    repeater = Repeater("Hello again!")
    for item in repeater:
        print(item)

if __name__ == "__main__":
    main()
