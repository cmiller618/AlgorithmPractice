package sortingpractice;

import java.util.ArrayList;
import java.util.List;

public class Merge_Sort {
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

        List<Integer> sorted = cutInHalf(numbers);

        System.out.println(sorted);

    }

    private static List<Integer> cutInHalf(List<Integer> list){
        if (list.size() <= 1){
            return list;
        }
        double middle = Math.floor((double) list.size() / 2);
        List<Integer> left = cutInHalf(list.subList(0, (int) middle));
        List<Integer> right = cutInHalf(list.subList((int) middle, list.size()));
        return merge(left, right);
    }
    private static List<Integer> merge(List<Integer> list1, List<Integer> list2){
        int i = 0, j = 0;
        List<Integer> sorted = new ArrayList<>();
        while (i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                sorted.add(list1.get(i));
                i++;
            }else{
                sorted.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            sorted.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            sorted.add(list2.get(j));
            j++;
        }


        return sorted;
    }

    
}
