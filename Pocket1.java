import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Pocket1{
    public static void main(String[] args) {
        int[] arr1 = {-5,-9,1,2,-2,4};
        System.out.println(maxRate(arr1));
    }

    public static int maxRate(int[] ratings){
        int l = ratings.length;
        int res = 0;
        int[] neg = new int[l];
        int index = -1;
        for(int i = 0; i < l; i++){
            if(ratings[i] < 0){
                neg[++index] = ratings[i];
            }
            else{
                res += ratings[i];
                if(index > 0){
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int a = 0; a < index; a = a+2){
                        sum1 += neg[a];
                    }
                    for(int b = 1; b < index + 1; b = b+2){
                        sum2 += neg[b];
                    }
                    res += Math.max(sum1, sum2);
                }
                neg = new int[l];
                index = -1;
            }
            if(index == l - 1){
                int sum1 = 0;
                int sum2 = 0;
                for(int a = 0; a < l; a = a+2){
                    sum1 += ratings[a];
                }
                for(int b = 1; b < l; b = b+2){
                    sum2 += ratings[b];
                }
                res += Math.max(sum1, sum2);
            }
       }
       return res;
    }
}