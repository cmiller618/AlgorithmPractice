import math


class Node:

    def __init__(self, data):
        self.data = data
        self.next_node = None

    def __repr__(self):
        return self.data


class SinglyLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None
        self.num_of_nodes = 0

    def insert_start(self, data):
        self.num_of_nodes += 1
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next_node = self.head
            self.head = new_node

    def insert_end(self, data):
        self.num_of_nodes += 1
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next_node = new_node
            self.tail = new_node

    def size_of_list(self):
        return self.num_of_nodes

    def traverse(self):
        actual_node = self.head

        while actual_node is not None:
            print(actual_node.data)
            actual_node = actual_node.next_node

    def remove(self, data):
        if self.head is None:
            return

        actual_node = self.head
        previous_node = None

        while actual_node is not None and actual_node.data != data:
            previous_node = actual_node
            actual_node = actual_node.next_node

        if actual_node is None:
            return

        if previous_node is None:
            self.head = actual_node.next_node
        else:
            previous_node.next_node = actual_node.next_node

    def find_middle_node(self):
        middle = math.floor(self.num_of_nodes / 2)
        node = self.head

        for i in range(0, middle):
            node = node.next_node

        return node.data

    def reverse(self):
        node = self.head
        self.head = self.tail
        self.tail = node
        previous = None
        for i in range(0, self.num_of_nodes):
            next = node.next_node
            node.next_node = previous
            previous = node
            node = next


if __name__ == '__main__':
    linked_list = SinglyLinkedList()
    linked_list.insert_end(1)
    linked_list.insert_start(2)
    linked_list.insert_start(3)
    linked_list.insert_start(4)
    linked_list.insert_start(5)
    print(linked_list.find_middle_node())
    linked_list.traverse()
    linked_list.reverse()
    linked_list.traverse()
