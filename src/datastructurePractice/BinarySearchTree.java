package datastructurePractice;

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



}
