import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class blizzard1{
    public static void main(String[] args) {
        
    }

    public static String canReach(int x1, int y1, int x2, int y2) {
        while(x2 != 1 || y2 != 1){
            if(x2 < y2){
                y2 -= x2;
            } else {
                x2 -= y2;
            }

            if(x1 == x2 && y1 == y2){
                return "Yes";
            }
            if(x2 == 0){
                return "No";
            }
        }

        if(x1 == x2 && y1 == y2){
            return "Yes";
        }
        
        return "No";
    }
}