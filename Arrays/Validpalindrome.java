package Arrays;

public class Validpalindrome {
    public static boolean ispalindrome(String s ){
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else{
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    static void main(String[] args) {

        String s = "madam";

        System.out.println(ispalindrome(s));

    }
}
