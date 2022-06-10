import java.util.ArrayList;
import java.util.List;

public class Insertion_Sort {
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

        for(int i = 1; i < numbers.size(); i++){
            int currentValue = numbers.get(i);
            int index = i;
            for(int j = i - 1; j >= 0 && numbers.get(j) > currentValue; j--){
                numbers.set(j + 1, numbers.get(j));
                index = j;
            }
            numbers.set(index, currentValue);
        }

        System.out.println(numbers);
    }
}
