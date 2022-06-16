class MaxStack:
    def __init__(self):
        self.main_stack = []
        self.max_stack = []

    def push(self, data):
        self.main_stack.append(data)

        if len(self.main_stack) == 1:
            self.main_stack.append(data)

        if data > self.max_stack[-1]:
            self.main_stack.append(data)
        else:
            self.main_stack.append(self.max_stack[-1])

    def pop(self):
        self.main_stack.pop()
        return self.main_stack.pop()

    def get_max_item(self):
        return self.max_stack.pop()