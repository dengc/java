import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard2{
    public static void main(String[] args) {
        
    }
    public static String[] braces(String[] values) {
        int l = values.length;
        String[] res = new String[l];
        for(int i = 0; i < l; i++){
        	String s = values[i];
        	if(isValid(s)){
        		res[i] = "YES";
        	}else{
        		res[i] = "NO";
        	}
        }
        return res;
    }

    public static boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q);
        }
        return p.isEmpty();
    }
}