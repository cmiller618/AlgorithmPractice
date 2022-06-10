package recursionPractice;

public class reverse {

    public static void main(String[] args) {

        System.out.println(reverse("awesome"));
        System.out.println(reverse("programming"));
    }

    private static String reverse(String str){
        if(str.length() <= 1) return str;
        StringBuilder s = new StringBuilder(str);

        return str.charAt(str.length() - 1) + reverse(String.valueOf(s.deleteCharAt(str.length() - 1)));
    }

}
