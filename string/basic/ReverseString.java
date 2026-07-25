package string.basic;

public class ReverseString {
    public void reverseString(char[] s){
        StringBuilder reverse = new StringBuilder(new String(s)).reverse();
        for(int i = 0; i< s.length ; i++){
            s[i] = reverse.charAt(i);
        }
    }

    static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        ReverseString r = new ReverseString();
        r.reverseString(s);
        System.out.println(s);

    }
}
