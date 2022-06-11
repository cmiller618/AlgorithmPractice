package datastructurePractice;

//A representation of Singly Linked list
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int number;
        Node next;

        Node(int data){
            this.number = number;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    public SinglyLinkedList push(int number){
        Node newNode = new Node(number);
        if(this.head == null){ //if head is empty, that means the list is empty, so add value to head and tail
            this.head = newNode;
            this.tail = this.head;
        }else{// else update tail
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    //removes item in the list at the end. Sets the second to last value as the tail by looping through list
    public Node pop(){
        if(this.head == null){
            return null;
        }
        var current = this.head;
        var newTail = current;
        while(current.next != null){
            newTail = current;
            current = current.next;
        }
        this.tail = newTail;
        this.tail.next = null;
        this.length--;
        if(this.length == 0){
            this.head = null;
            this.tail = null;
        }
        return current;

    }

    //removes value from the head of the list
    public Node shift(){
        if(this.head == null){
            return null;
        }

        Node currentHead = this.head;
        this.head = currentHead.next;
        this.length--;
        if(this.length == 0){
            this.tail = null;
        }
        return currentHead;
    }

    public SinglyLinkedList unshift(int number){
        Node newNode = new Node(number);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        }else{
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
        int counter = 0;
        var current = this.head;

        while(counter != index){
            current = current.next;
            counter++;
        }
        return current;
    }

    public boolean set(int index, int value){
        Node node = this.get(index);
        if(node == null){
            return false;
        }
        node.number = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > this.length){
            return false;
        }
        if (index == this.length){
            return this.push(value) != null;
        }
        if (index == 0){
            return this.unshift(value) != null;
        }

        Node newNode = new Node(value);
        Node previous = this.get(index - 1);
        Node temp = previous.next;
        previous.next = newNode;
        newNode.next = temp;
        this.length++;
        return true;

        }

    public Node remove(int index){
        if(index < 0 || index >= this.length){
            return null;
        }

        if(index == this.length - 1){
            return this.pop();
        }
        if(index == 0){
            return this.shift();
        }

        Node previous = this.get(index- 1);
        Node removed = previous.next;
        previous.next = removed.next;
        this.length--;
        return removed;
    }

    public SinglyLinkedList reverse(){
        Node node = this.head;
        this.head = this.tail;
        this.tail = node;
        Node next;
        Node previous = null;
        for(int i = 0; i < this.length; i++){
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return this;
    }


}
