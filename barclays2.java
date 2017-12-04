import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] parts = line.split(",");
      int n = Integer.parseInt(parts[0]);
      int interval = Integer.parseInt(parts[1]) - 1;
      
      LinkedList<Integer> lines = new LinkedList<Integer>();
      
      for(int i = 0; i < n; i++){
        lines.add(i);
      }
      
      int index = 0;
      while(lines.size() > 0){
        int nextIndex = index + interval;
        while(nextIndex >= lines.size()){
          nextIndex -= lines.size();
        }
        System.out.print(lines.get(nextIndex) + " ");
        index = nextIndex;
        lines.remove(nextIndex);
        
        if(lines.size() == 1){
          System.out.println(lines.get(0));
          break;
        }
      }
    }
  }
}


