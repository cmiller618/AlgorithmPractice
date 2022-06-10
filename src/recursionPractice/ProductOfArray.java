package recursionPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductOfArray {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            numbers.add(random.nextInt(5) + 1);
        }
        System.out.println(numbers);
        System.out.println(product(numbers));
    }

    private static int product(List<Integer> numbers){

        if(numbers.size() == 0){
            return 1;
        }
        int number = numbers.get(numbers.size() - 1);
        numbers.remove(numbers.size() - 1);
        return number * product(numbers);
    }
}
