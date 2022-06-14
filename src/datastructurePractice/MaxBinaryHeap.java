package datastructurePractice;

import java.util.ArrayList;
import java.util.List;

public class MaxBinaryHeap {
    List<Integer> values;

    public MaxBinaryHeap(){
        List<Integer> values = new ArrayList<>();
    }

    public void insert(int number){
        this.values.add(number);
        this.bubbleUp();
    }

    public void bubbleUp(){
        int index = this.values.size() - 1;
        int number = this.values.get(index);
        while(index > 0){
            int parentIndex = (int) Math.floor((index - 1) / 2);
            int parent = this.values.get(parentIndex);
            if (number <= parent) break;
            this.values.set(parentIndex, number);
            this.values.set(index, parent);
            index = parentIndex;

        }
    }

    public int extractMax(){
        int root = this.values.get(0);
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
        int parent = this.values.get(parentIndex);
        while(true) {
            int left = 2 * parentIndex + 1;
            int right = 2 * parentIndex + 2;
            int leftChild = 0, rightChild = 0;
            int swap = -1;

            if(left < length){
                leftChild = this.values.get(left);
                if (leftChild > parent){
                    swap = left;
                }
            }
            if(right < length){
                rightChild = this.values.get(right);
                if ((swap == -1 && rightChild > parent) || (swap > -1 && rightChild > leftChild)){
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
