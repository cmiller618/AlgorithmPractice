package recursionPractice;

import java.util.Random;

public class Fibonacci {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        System.out.println(number);
        System.out.println(fibonaccci(number));
    }

    private static int fibonaccci(int number){
        if(number <= 2){
            return 1;
        }

        return fibonaccci(number - 1) + fibonaccci(number - 2);
    }
}
