class Queue_Stack:

    def __init__(self):
        self.enqueue_stack = []
        self.dequeue_stack = []

    def enqueue(self, data):
        self.enqueue_stack.append(data)

    def dequeue(self):

        if len(self.enqueue_stack) == 0 and len(self.dequeue_stack) == 0:
            return

        if len(self.dequeue_stack) == 0:
            while len(self.enqueue_stack) != 0:
                self.dequeue_stack.append(self.enqueue_stack.pop())

        return self.dequeue_stack.pop()