package datastructurePractice;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<Node> values;

    public PriorityQueue(){
        List<Node> values = new ArrayList<>();
    }

    class Node{
        private int value;
        private int priority;

        public Node(int value, int priority){
            this.value = value;
            this.priority = priority;
        }
    }

    public void enqueue(int value, int priority){
        Node newNode = new Node(value, priority);
        this.values.add(newNode);
        this.bubbleUp();
    }

    public void bubbleUp(){
        int index = this.values.size() - 1;
        Node number = this.values.get(index);
        while(index > 0){
            int parentIndex = (int) Math.floor((index - 1) / 2);
            Node parent = this.values.get(parentIndex);
            if (number.priority >= parent.priority) break;
            this.values.set(parentIndex, number);
            this.values.set(index, parent);
            index = parentIndex;

        }
    }

    public Node dequeue(){
        Node root = this.values.get(0);
        this.values.set(0, this.values.get(this.values.size() - 1));
        this.values.set(this.values.size() - 1, root);
        if(this.values.size() > 0) {
            this.values.remove(this.values.size() - 1);
            sinkDown();
        }
        return root;
    }

    public void sinkDown(){
        int parentIndex = 0;
        int length = this.values.size();
        Node parent = this.values.get(parentIndex);
        while(true) {
            int left = 2 * parentIndex + 1;
            int right = 2 * parentIndex + 2;
            Node leftChild = null;
            Node rightChild = null;
            int swap = -1;

            if(left < length){
                leftChild = this.values.get(left);
                if (leftChild.priority < parent.priority){
                    swap = left;
                }
            }
            if(right < length){
                rightChild = this.values.get(right);
                if ((swap == -1 && rightChild.priority < parent.priority) || (swap > -1 && rightChild.priority < leftChild.priority)){
                    swap = right;
                }
            }

            if(swap == -1) break;

            this.values.set(parentIndex, this.values.get(swap));
            this.values.set(swap, parent);
            parentIndex = swap;
        }
    }
}
