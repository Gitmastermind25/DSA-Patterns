import java.util.*;
public class CharacterReplacement{
    static int find(int[] a){
        int maxc = -1;
        for(int i =0;i<256;i++){
            maxc= Math.max(maxc,a[i]);
        }
        return maxc;
    }
    static int characterReplacement(String s,int k){
        int n =s.length();
        int[] f = new int[256];
        int low = 0;
        int res = Integer.MIN_VALUE;
        for(int high=0; high<n; high++){
            f[s.charAt(high)]++;
            int maxcnt = find(f);
            int len = high-low+1;
            int diff = len - maxcnt;
            while(diff>k){
                f[s.charAt(low)]--;
                low++;
                maxcnt = find(f);
                len = high - low +1;
                diff = len - maxcnt;
            }
            res = Math.max(res,high-low+1);
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        System.out.print("Enter k: ");
        int k = sc.nextInt();


        int result = characterReplacement(s, k);
        System.out.println("Longest length: " + result);

        sc.close();

    }
}