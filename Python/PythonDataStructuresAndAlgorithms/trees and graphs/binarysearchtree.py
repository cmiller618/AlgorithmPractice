class TreeComparator:
    def compare(self, node1, node2):
        if not node1 or not node2:
            return node1 == node2

        if node1.data is not node2.data:
            return False

        return self.compare(node1.left, node2.left) and self.compare(node1.right, node2.right)


class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.left = None
        self.right = None
        self.parent = parent


class BinarySearchTree:
    def __init__(self):
        self.root = None

    def remove(self, data):
        if self.root:
            self.remove_node(data, self.root)

    def remove_node(self, data, node):
        if node is None:
            return

        if data < node.data:
            self.remove_node(data, node.left)
        elif data > node.data:
            self.remove_node(data, node.right)
        else:
            if node.left is None and node.right is None:
                parent = node.parent
                if parent is not None and parent.left == node:
                    parent.left = None
                if parent is not None and parent.right == node:
                    parent.right = None
                if parent is None:
                    self.root = None
                del node

            elif node.left is None and node.right is not None:
                parent = node.parent
                if parent is not None and parent.left == node:
                    parent.left = node.right
                if parent is not None and parent.right == node:
                    parent.right = node.right

                if parent is None:
                    self.root = node.right

                node.right.parent = parent
                del node
            elif node.right is None and node.left is not None:
                parent = node.parent
                if parent is not None and parent.left == node:
                    parent.left = node.left
                if parent is not None and parent.right == node:
                    parent.right = node.left
                if parent is None:
                    self.root = node.left
                node.left.parent = parent
                del node
            else:
                predecessor = self.get_predecessor(node.left)
                temp = predecessor.data
                predecessor.data = node.data
                node.data = temp

                self.remove_node(data, predecessor)

    def get_predecessor(self, node):
        if node.right:
            return self.get_predecessor(node.right)
        return Node

    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self.insert_node(data, self.root)

    def insert_node(self, data, node):
        if data < node.data:
            if node.left:
                self.insert_node(data, node.left)
            else:
                node.left = Node(data, node)
        else:
            if node.right:
                self.insert_node(data, node.right)
            else:
                node.right = Node(data, node)

    def get_min(self):
        if self.root:
            return self.get_min_value(self.root)

    def get_min_value(self, node):
        if node.left:
            return self.get_min_value(node.left)

        return node.data

    def get_max(self):
        if self.root:
            return self.get_min_value(self.root)

    def get_max_value(self, node):
        if node.right:
            return self.get_min_value(node.right)

        return node.data

    def traverse(self):
        if self.root:
            self.traverse_in_order(self.root)

    def traverse_in_order(self, node):
        if node.left:
            self.traverse_in_order(node.left)
        print(node.data)
        if node.right:
            self.traverse_in_order(node.right)
