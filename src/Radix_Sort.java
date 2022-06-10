import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Radix_Sort {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            numbers.add(rand.nextInt(1000) + 1);
        }
        System.out.println(numbers);

        List<Integer> sorted = new ArrayList<>();
        sorted = radixSort(numbers);
        System.out.println(sorted);
    }

    private static List<Integer> radixSort(List<Integer> numbers){
        int most = mostDigits(numbers);
        List<List<Integer>> digits = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            digits.add(i, new ArrayList<>());
        }

        for(int i = 0; i < most; i++){

            for (Integer number : numbers) {

                int digit = getDigit(number, i);
                List<Integer> bucket = digits.get(digit);
                digits.set(digit, bucket).add(number);
            }
            numbers.clear();
            List<Integer> bucket = new ArrayList<>();
            for(int j = 0; j < digits.size(); j++){
                numbers.addAll(digits.get(j).stream().toList());
                digits.get(j).clear();
            }

        }
        return numbers;

    }

    private static int getDigit(int number, int place){
        return (int)Math.floor(Math.abs(number) / Math.pow(10, place)) % 10;
    }

    private static int mostDigits(List<Integer> numbers){
        int most = 0;
        for(int i = 0; i < numbers.size(); i++){
            int digit = digitCount(numbers.get(i));
            most = Math.max(most, digit);
        }

        return most;
    }

    private static int digitCount(int number){
        if(number == 0){
            return 1;
        }
        return (int) (Math.floor(Math.log10(Math.abs(number))) + 1);
    }

}
