package recursionPractice;

import java.util.Random;

public class RecursiveRange {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10) + 1;

        System.out.println(number);
        System.out.println(range(number));
    }

    private static int range(int number){
        if(number == 0){
            return number;
        }

        return number + range(number - 1);
    }
}
