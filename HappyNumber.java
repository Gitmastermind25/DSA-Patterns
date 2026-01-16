public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();  // FIXED
        int n = 19;
        System.out.println(sol.isHappy(n)); // true
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
