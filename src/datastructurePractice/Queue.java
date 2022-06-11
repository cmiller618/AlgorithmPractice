package datastructurePractice;

public class Queue {
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

    public Queue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int enqueue(int number){
        Node newNode = new Node(number);
        if(this.size == 0){
            this.first = newNode;
            this.last = newNode;
        }else{
            this.last.next = newNode;
            this.last = newNode;
        }
        return ++this.size;

    }

    public Node dequeue(){
        if(this.size == 0){
            return null;
        }

        Node currentFirst = this.first;
        if(this.first == this.last){
            this.last = null;
        }
        this.first = this.first.next;
        currentFirst.next = null;
        return currentFirst;
    }
}
