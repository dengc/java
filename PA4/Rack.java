// Name:Chufan Deng
// USC NetID: chufande
// CS 455 PA4
// Spring 2017

import java.util.ArrayList;
import java.util.*;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {

    private String word;

    public Rack(String s){
        word = s.toLowerCase();
    }

    public ArrayList<String> getSubnets(){
        ArrayList<String> allCombos = new ArrayList<>();
        int l = word.length();
        int count = 0;
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();

        //count numbers of each letter appears
        for(int i = 0; i < l; i++){
            String sub = word.substring(i,i+1);
            if(wordsMap.containsKey(sub)){
                wordsMap.put(sub,wordsMap.get(sub)+1);
            }
            else {
                wordsMap.put(sub,1);
                count++;
            }
        }
        //initialize int array and uniqueWord string for the comming recursive function
        int[] nums = new int[count];
        String uniqueWord = "";
        count = 0;
        for (Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            uniqueWord += entry.getKey();
            nums[count++] = entry.getValue();
        }
        allCombos = allSubsets(uniqueWord, nums, 0);
        return allCombos;
    }
   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }

      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);

      // prepend all possible numbers of the first char (i.e., the one at position k)
      // to the front of each string in restCombos.  Suppose that char is 'a'...

      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      return allCombos;
   }
}
