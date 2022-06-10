package searchingPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearSearch {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 35; i++){
            numbers.add(random.nextInt(25) + 1);
        }

        System.out.println(linearSearch(numbers, 10));
        System.out.println(linearSearch(numbers, 15));
        System.out.println(linearSearch(numbers, 40));
    }

    private static int linearSearch(List<Integer> numbers, int searchedNumber){

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == searchedNumber){
                return i;
            }
        }

        return -1;
    }
}
