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
      int part = line.indexOf("|");
      String port = line.substring(0, part);
      String bench = line.substring(part+1, line.length());
      Scanner sc_port = new Scanner (port).useDelimiter("[^\\w\\s]");
      Scanner sc_bench = new Scanner (bench).useDelimiter("[^\\w\\s]");
      sc_port.next();
      sc_bench.next();
      int nav_p = 0;
      int nav_b = 0;
      while(sc_port.hasNext()){
        sc_port.next();
        int q = Integer.parseInt(sc_port.next());
        int p = Integer.parseInt(sc_port.next());
        nav_p += q * p;
      }
      while(sc_bench.hasNext()){
        sc_bench.next();
        int q = Integer.parseInt(sc_bench.next());
        int p = Integer.parseInt(sc_bench.next());
        nav_b += q * p;
      }
      HashMap<String, Double> portMap = new HashMap<String, Double>();
      HashMap<String, Double> benchMap = new HashMap<String, Double>();
      sc_port = new Scanner (port).useDelimiter("[^\\w\\s]");
      sc_bench = new Scanner (bench).useDelimiter("[^\\w\\s]");
      sc_port.next();
      sc_bench.next();
      while(sc_port.hasNext()){
        String stock = sc_port.next();
        int q = Integer.parseInt(sc_port.next());
        int p = Integer.parseInt(sc_port.next());
        double per = p * q * 100 / nav_p;
        portMap.put(stock, Double.parseDouble(String.format("%.2f", per)));
      }
      while(sc_bench.hasNext()){
        String stock = sc_bench.next();
        int q = Integer.parseInt(sc_bench.next());
        int p = Integer.parseInt(sc_bench.next());
        double per = p * q * 100 / nav_b;
        benchMap.put(stock, Double.parseDouble(String.format("%.2f", per)));
      }
      String res = "";
      for (String stock : portMap.keySet()) {
          if(benchMap.keySet().contains(stock)){
            res = res.concat(stock + ":");
            double diff = portMap.get(stock) - benchMap.get(stock);
            res = res.concat(diff + ",");
          }else{
            res = res.concat(stock + ":");
            double diff = portMap.get(stock);
            res = res.concat(diff + ",");
          }
      }
      for (String stock : benchMap.keySet()) {
          if(!portMap.keySet().contains(stock)){
            res = res.concat(stock + ":");
            double diff = 0 - benchMap.get(stock);
            res = res.concat(diff + ",");
          }
      }
      System.out.println(res);
    }
  }
}
