import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String start_end = in.nextLine();
        String[] period = start_end.split(",");
        String start = period[0].trim();
        String end = period[1].trim();
        Date date1 = new SimpleDateFormat("yyyy-MM").parse(start);
        Date date2 = new SimpleDateFormat("yyyy-MM").parse(end);
        in.nextLine();
        TreeMap<String, TreeMap<String,Integer>> res = new TreeMap<String, TreeMap<String,Integer>>(Collections.reverseOrder());
        TreeMap<String, Integer> content = new TreeMap<String, Integer>();
        while(in.hasNextLine()){
        	String data = in.nextLine();
        	String[] details = data.split(",");
        	String date = details[0].trim();
        	Date toCompare = new SimpleDateFormat("yyyy-MM").parse(date);
        	if((toCompare.after(date1) && toCompare.before(date2)) || toCompare.equals(date1)){
        		String str = details[1].trim();
        		int num = Integer.parseInt(details[2].trim());
        		date = date.substring(0,7);
        		if(res.keySet().contains(date)){
        			res.get(date).put(str, res.get(date).getOrDefault(str, 0) + num);
        		}else {
        			content.put(str, num);
        			res.put(date, content);
        			content = new TreeMap<String, Integer>();
        		}
        	}
        }

        for(String d : res.keySet()){
        	String con = res.get(d).toString();
        	con = con.replace("{", ", ");
        	con = con.replace("}", "");
        	con = con.replace("=", ", ");
        	String out = d.concat(con);
        	System.out.println(out);

        }
    }
}