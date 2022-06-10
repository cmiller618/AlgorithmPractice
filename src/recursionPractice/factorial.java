package recursionPractice;

import java.util.Random;

public class factorial {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        System.out.println(number);
        System.out.println(factorial(number));
    }

    private static int factorial(int number){
        if(number == 1){
            return 1;
        }
        return number * factorial(number - 1);
    }
}
