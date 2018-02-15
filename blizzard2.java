import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard2{
    public static void main(String[] args) {
        
    }
    public static int[] getOneBits(int n) {
    	int count = 0;
    	int h = n;
        while(h != 0){
            h = h & (h-1);
            count++;
        }
        int l = count + 1;
        int[] res = new int[l];
        res[0] = count;
        String s = Integer.toBinaryString(n);
        char[] charS = s.toCharArray();
        int index = 1;
        for(int i = 0; i < charS.length; i++){
        	if(charS[i] == '1'){
        		res[index++] = i + 1;
        	}
        }
        return res;
    }
}