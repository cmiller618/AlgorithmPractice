package datastructurePractice;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        private int number;
        private Node next;
        private Node previous;

        public Node(int number){
            this.number = number;
            this.next = null;
            this.previous = null;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public DoublyLinkedList push(int number){
        Node newNode = new Node(number);
        if(this.length == 0){
            this.head = newNode;
            this.tail = this.head;
        }else{
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    public Node pop(){
        if (this.head == null){
            return null;
        }

        Node currentTail = this.tail;

        if(this.length == 1){
            this.head = null;
            this.tail = null;
        }else{
            this.tail = currentTail.previous;
            this.tail.next = null;
            currentTail.previous = null;
        }
        this.length--;
        return currentTail;
    }

    public Node shift(){
        if(this.length == 0){
            return null;
        }
        Node currentHead = this.head;

        if(this.length == 1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = currentHead.next;
            this.head.previous = null;
            currentHead.next = null;
        }
        this.length--;
        return currentHead;
    }

    public DoublyLinkedList unshift(int value){
        Node newNode = new Node(value);
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.head.previous = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    public Node get(int index){
        if(index < 0 || index >= this.length){
            return null;
        }
        Node current;
        if(index >= this.length / 2){
            current = this.tail;
            for(int i = this.length; i > index; i--){
                current = current.previous;
            }

        }else{
            current = this.head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }
        return current;
    }

    public boolean set(int index, int number){
        Node node = this.get(index);
        if(node == null){
            return false;
        }
        node.number = number;
        return true;
    }

    public boolean insert(int index, int number){
        if(index < 0 || index > this.length){
            return false;
        }
        if(index == 0){
            return this.unshift(number) != null;
        }else if(index == this.length){
            return this.push(number) != null;
        }

        Node newNode = new Node(number);
        Node previousNode = this.get(index - 1);
        Node nextNode = previousNode.next;

        previousNode.next = newNode;
        newNode.previous = previousNode;
        newNode.next = nextNode;
        nextNode.previous = newNode;
        this.length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= this.length){
            return null;
        }
        if(index == 0){
            return this.shift();
        }
        if(index == this.length - 1){
            return this.pop();
        }

        Node node = this.get(index);
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
        node.next = null;
        node.previous = null;
        this.length--;
        return node;
    }
}
