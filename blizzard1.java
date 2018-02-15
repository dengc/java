import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard1{
    public static void main(String[] args) {
        
    }

    public static String mergeStrings(String a, String b) {
    	String res = "";
    	StringBuilder sb = new StringBuilder();

    	char[] charA = a.toCharArray();
    	char[] charB = b.toCharArray();
    	int la = charA.length;
    	int lb = charB.length;
    	int index = 0;
    	while(index < la && index < lb){
    		sb.append(charA[index]);
    		sb.append(charB[index]);
    		index++;
    	}
    	if(la > lb){
    		while(index < la){
    			sb.append(charA[index]);
    			index++;
    		}
    	}else if (lb > la) {
    		while(index < lb){
    			sb.append(charB[index]);
    			index++;
    			
    		}
    	}
    	res = sb.toString();
    	return res;
    }
}