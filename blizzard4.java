import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard2{
    public static void main(String[] args) {
        
    }
    public static String electionWinner(String[] votes) {
        String res = "";
      	HashMap<String, Integer> map = new HashMap<String, Integer>();
      	int max = 1;

      	for(String s : votes){
      		if(map.keySet().contains(s)){
      			int count = map.get(s) + 1;
      			map.put(s, count);
      			if(count == max){
      				if(s.compareTo(res) > 0){
      					res = s;
      				}
      			}
      			else if(count > max){
      				max = count;
      				res = s;
      			}
      		}
      		else{
      			map.put(s,1);
      		}
      	}

    	return res;
    }


}