package recursionPractice;

import java.util.ArrayList;
import java.util.List;

public class Captialize {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        words.add("cookie");
        words.add("pizza");
        words.add("television");
        words.add("store");

        System.out.println(capitalize(words, words.size()));
    }

    private static String capitalize(List<String> words, int size){
        if(size <= 1){
            return words.get(size - 1).substring(0, 1).toUpperCase() + words.get(size - 1).substring(1);
        }
        List<String> newWords = new ArrayList<>();
        String uppercase = words.get(size - 1).substring(0, 1).toUpperCase() + words.get(size - 1).substring(1);

        return uppercase + "\n" + capitalize(words, size - 1);
    }
}
