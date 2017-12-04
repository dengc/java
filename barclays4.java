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
      Scanner console = new Scanner(line);
      System.out.println(evaluate(console));
    }
  }
   public static int evaluate(Scanner input) {
        if (input.hasNextInt()) {
            return input.nextInt();
        } else {
            String operator = input.next();
            int operand1 = evaluate(input);
            int operand2 = evaluate(input);
            return evaluate(operator, operand1, operand2);
        }
    }

    public static int evaluate(String operator, int operand1,
                                  int operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else if (operator.equals("%")) {
            return operand1 % operand2;
        } else {
            throw new RuntimeException("illegal operator " + operator);
        }
    }
}
