import java.util.ArrayList;
import java.util.List;

public class Bubble_Sort {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for(int i = 29; i > 0; i--){
            if(i % 2 == 0){
                numbers.add(i * 2);
            }else{
                numbers.add(i - 10);
            }
        }
        System.out.print(numbers);
        for(int i = numbers.size(); i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if (numbers.get(j) > numbers.get(j + 1)){
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        System.out.println(numbers);

    }
}
