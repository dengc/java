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
    Stack<Integer> stack = new Stack<Integer>();
    while ((line = in.readLine()) != null) {
      for(String s : line.split(" ")){
        int num = Integer.parseInt(s);
        stack.push(num);
      }
      while(!stack.isEmpty()){
        System.out.print(stack.pop() + " ");
        stack.pop();
      }

    }
  }
}
