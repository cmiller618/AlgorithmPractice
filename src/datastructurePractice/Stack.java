package datastructurePractice;

public class Stack {
    private Node first;
    private Node last;
    private int size;
    class Node{
        private int number;
        private Node next;

        public Node(int number){
            this.number = number;
            this.next = null;
        }
    }

    public Stack(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int push(int value){
        Node newNode = new Node(value);
        if (this.size == 0){
            this.first = newNode;
            this.last = newNode;
        }else{
            Node currentFirst = this.first;
            this.first = newNode;
            this.first.next = currentFirst;
        }
        return ++this.size;
    }

    public Node pop(){
        if(this.size <= 0){
            return null;
        }
        Node removed = this.first;
        if(this.first == this.last){
            this.last = null;
        }
        this.first = this.first.next;
        this.size--;
        return removed;
    }


}
