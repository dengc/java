import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard1{
    public static void main(String[] args) {
        
    }

    public static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int l = expressions.length;
        int[] res = new int[l];
        for(int i = 0; i < l; i++){
            int left = 0;
            int right = 0;
            String exp = expressions[i];
            int len = exp.length();
            int max = maxReplacements[i];
            if(exp.substring(len-1, len).equals("<")){
                res[i] = 0;
            }
            else{
                int count = 0;
                for(int j = 0; j < len; j++){
                    if(exp.substring(j, j + 1).equals("<")){
                        left++;
                        count--;
                    }else{
                        right++;
                        if(count < 0){
                            count++;
                        }
                    }
                }
                if(count < 0){
                    res[i] = 0;
                }else if(left > right){
                    res[i] = 0;
                }else if (right - left > max) {
                    res[i] = 0;
                }else{
                    res[i] = 1;
                }
            }
        }
        return res;
    }

}