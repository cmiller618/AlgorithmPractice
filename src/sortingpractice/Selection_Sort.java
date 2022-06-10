package sortingpractice;

import java.util.ArrayList;
import java.util.List;

public class Selection_Sort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 30; i > 0; i--){
            if(i % 2 == 0){
                numbers.add((i - 1) * 2);
            }else{
                numbers.add((i - 1) - 10);
            }
        }
        System.out.println(numbers);
        int index = 0;

        for(int i = 0; i < numbers.size(); i++){
            int minimum = i;
            for(int j = i; j < numbers.size(); j++){
                if(numbers.get(minimum) > numbers.get(j)){
                    minimum = j;
                }
            }

            int temp = numbers.get(minimum);
            numbers.set(minimum, numbers.get(i));
            numbers.set(i, temp);
        }

        System.out.println(numbers);

    }
}
