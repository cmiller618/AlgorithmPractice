package datastructurePractice;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    class Node{

        private int number;
        private Node left;
        private Node right;

         public Node(int number){
            this.number = number;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree insert(int number){
        Node newNode = new Node(number);
        if (this.root == null){
            this.root = newNode;
            return this;
        }else{
            Node current = this.root;
            while(true){
                if(number == current.number){
                    return null;
                }
                if(number < current.number){
                    if(current.left == null){
                        current.left = newNode;
                        return this;
                    }else{
                        current = current.left;
                    }
                }else if (number > current.number){
                    if(current.right == null) {
                        current.right = newNode;
                        return this;
                    }else {
                        current = current.right;
                    }
                }
            }
        }

    }

    public boolean find(int number){
        if(this.root == null){
            return false;
        }
        Node current = this.root;
        boolean found = false;

        while (!found && current != null){
            if (number < current.number){
                current = current.left;
            }else if (current == current.right){
                current = current.right;
            }else{
                return true;
            }
        }

        return false;
    }

    public List<Node> breadthFirstSearch(){
        Node node = this.root;
        List<Node> data = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(node);
        while(queue.size() > 0){
            node = queue.remove(0);
            data.add(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return data;
    }

    public List<Node> dfsPreOrder(){
        List<Node> data = new ArrayList<>();
        Node current = this.root;
        data = traversePreOrder(current, data);
        return data;
    }

    public List<Node> dfsPostOrder(){
        List<Node> data = new ArrayList<>();
        Node current = this.root;
        data = traversePostOrder(current, data);
        return data;
    }

    public List<Node> dfsInOrder(){
        List<Node> data = new ArrayList<>();
        Node current = this.root;
        data = traversePostOrder(current, data);
        return data;
    }

    private List<Node> traverseInOrder(Node node, List<Node> data){
        if(node.left != null){
            traverseInOrder(node.left, data);
        }
        data.add(node);
        if(node.right != null){
            traverseInOrder(node.right, data);
        }

        return data;
    }

    private List<Node> traversePostOrder(Node node, List<Node> data){
        if(node.left != null){
            traversePostOrder(node.left, data);
        }
        if(node.right != null){
            traversePostOrder(node.right, data);
        }
        data.add(node);
        return data;
    }

    private List<Node> traversePreOrder(Node node, List<Node> data){
        data.add(node);
        if(node.left != null){
            traversePreOrder(node.left, data);
        }
        if(node.right != null){
            traversePreOrder(node.right, data);
        }
        return data;
    }

}
