import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class ServiceTitan4{
    public static void main(String[] args) {
        int[] nums = {4,6,3,2};

        long res = kSub(3, nums);
        System.out.println(res);
    }

    public static long kSub(int k, int[] nums) {
        int[] sum = new int[nums.length];
        long count = 0;    
        sum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int [] kVal = new int[k];

        for(int i = 0; i < sum.length; i++){       
            int mod = sum[i] % k;

            if(mod == 0)
                count++;

            count += kVal[mod];
            kVal[mod] += 1;
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(kVal));
        return count;
    }
}