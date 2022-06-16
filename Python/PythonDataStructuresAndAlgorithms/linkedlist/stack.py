class Stack:
    def __init__(self):
        self.stack = []

    def push(self, data):
        self.stack.append(data)

    def pop(self):
        if self.stack_size() < 1:
            return

        data = self.stack[-1]
        del self.stack[-1]
        return data

    def peek(self):
        return self.stack[-1]

    def is_empty(self):
        return self.stack == []

    def stack_size(self):
        return len(self.stack)


stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
print('Size: %d' % stack.stack_size())
print("Item removed: %d" % stack.pop())
