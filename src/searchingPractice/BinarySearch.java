package searchingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 35; i++){
            numbers.add(random.nextInt(25) + 1);
        }

        System.out.println(binarySearch(numbers, 10));
        System.out.println(binarySearch(numbers, 15));
        System.out.println(binarySearch(numbers, 40));
    }

    private static int binarySearch(List<Integer> numbers, int searchedNumber){
        Collections.sort(numbers);
        int left = 0;
        int right = numbers.size() - 1;
        int middle = (int)Math.floor(numbers.size() / 2);

        while(left <= right){
            if(numbers.get(middle) == searchedNumber){
                return middle;
            }
            if (numbers.get(middle) < searchedNumber) {
                left = middle + 1;
            }if (numbers.get(middle) > searchedNumber){
                right = middle - 1;
            }
            middle = (int) Math.floor((right + left)/ 2);
        }

        return -1;
    }
}
