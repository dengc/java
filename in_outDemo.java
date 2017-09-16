import java.io.*;
import java.util.Scanner;

/**
   Reads a data set from a file. The file must have the format
   numberOfValues
   value1
   value2
   . . .
*/
public class in_outDemo
{

    public static void main(String[] args) throws IOException  {

        if (args.length < 1) {
           System.out.println("ERROR: missing file name");
        }
        else {
           String fileName = args[0];

           File newF = new File(fileName);
           Scanner in = new Scanner(newF);

           PrintWriter outFile = new PrintWriter("t2");

           while(in.hasNext()){
               String t1 = in.next();
               System.out.println(t1);
               outFile.println(t1 + "   hahahah ");
           }
           outFile.close();
        }
    }

}
