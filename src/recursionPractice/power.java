package recursionPractice;

import java.util.Random;

public class power {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(5) + 1;
        int power = random.nextInt(5) + 1;
        System.out.println(power(number, power));
    }

    private static int power(int number, int pow){
        if(pow == 0){
            return 1;
        }
        return number * power(number, pow - 1);
    }
}
