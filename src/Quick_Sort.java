import java.util.ArrayList;
import java.util.List;

public class Quick_Sort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            if(i  % 2 == 0){
                numbers.add(i * 10);
            }else{
                numbers.add(i);
            }
        }
        System.out.println(numbers);

        List<Integer> sorted = quickSort(numbers, 0, numbers.size() - 1);
        System.out.println(sorted);
    }

    public static int pivot(List<Integer> numbers, int start, int end){
        int pivot = start;
        for(int i = start + 1; i <= end; i++){
            if(numbers.get(i) < numbers.get(start)){
                pivot++;
                int temp = numbers.get(pivot);
                numbers.set(pivot, numbers.get(i));
                numbers.set(i, temp);
            }
        }
        if(pivot > 0){
            int temp = numbers.get(pivot);
            numbers.set(pivot, numbers.get(start));
            numbers.set(start, temp);
        }
        return pivot;
    }

    public static List<Integer> quickSort(List<Integer> numbers, int left, int right){
        if(left < right) {
            int pivot = pivot(numbers, left, right);

            quickSort(numbers, left, pivot - 1);
            quickSort(numbers, pivot + 1, right);
        }
        return numbers;
    }
}
