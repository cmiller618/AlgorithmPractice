package recursionPractice;

public class isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("car"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("racecar"));
    }

    private static boolean isPalindrome(String word){

        if(word.length() == 1){
            return true;
        }
        if(word.length() == 2){
            return word.charAt(0) == word.charAt(1);
        }

        if(word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
        return false;
    }
}
