import java.util.Scanner;
import java.io.*;

/**
 * Finds frequency of each word in a file.
 * Unlike the lecture version of this code, this one is smarter
 * about what it considers a word.
 *
 * Version for the lab.
 */

public class ConcordDriver {


    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
           System.out.println("ERROR: missing file name");
           return;
        }

	Concord concord = new Concord();
    String fileName = args[0];
    File newF = new File(fileName);
	Scanner in = new Scanner(newF);

	concord.addData(in);

    	concord.print(System.out);

        System.out.println("==========================");
     	concord.printSorted(System.out);

    }

}
