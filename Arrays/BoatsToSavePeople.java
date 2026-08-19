package Arrays;
import java.util.Arrays;
public class BoatsToSavePeople {
    public static int boatstosavepeople(int[] people, int limit){
        Arrays.sort(people);   //sort according to weight
        int i = 0;
        int j = people.length - 1;
        int boat = 0;
        while(i<=j){
            if(people[i]+people[j] <= limit){
                i++;
                j--;
            }else{
                j--; //heavyweight vale ko bhej do bus;
            }
            boat++;
        }
        return boat;
    }

    static void main(String[] args) {
        int[] people = {1,2,3,4,5};
        int limit = 4;
        System.out.println(boatstosavepeople(people,limit));
    }
}
