import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Pocket2{
    public static void main(String[] args) {
        int[] arr1 = {2,3,4,3,4};
        System.out.println(maxScore(arr1));
    }

    public static int maxScore(int[] ratings){
        Arrays.sort(ratings);
        int l = ratings.length;
        int res = 0;

        while(l > 0){
            int v = ratings[l - 1];
            res += v;
            l--;
            for(int i = 0; i < l; i++){
                if(ratings[i] == v - 1){
                    l--;
                    for(int j = i; j < l; j++){
                        ratings[j] = ratings[j+1];
                    }
                    break;
                }
            }
        }
        return res;
    }
}