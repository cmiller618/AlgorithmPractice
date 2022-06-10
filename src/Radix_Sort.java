import java.util.ArrayList;
import java.util.List;

public class Radix_Sort {
    public static void main(String[] args) {

    }

    private static List<Integer> radixSort(List<Integer> numbers){
        int most = mostDigits(numbers);
        List<Integer> newNumbers = new ArrayList<>();
        List<List<Integer>> digits = new ArrayList<>(10);

        for(int i = 0; i < most; i++){
            for(int j = 0; j < numbers.size(); j++) {
                int digit = getDigit(numbers.get(j), i);
                newNumbers.add(numbers.get(j));
                digits.get(digit).set(digit, newNumbers.get(j));
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
