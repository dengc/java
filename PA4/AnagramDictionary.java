// Name:Chufan Deng
// USC NetID: chufande
// CS 455 PA4
// Spring 2017

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


/**
 * A dictionary of all anagram sets.
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {

    private Map<String, String> anagramMap;

   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws IOException {

       anagramMap = new HashMap<String,String>();

       try{
           BufferedReader br = new BufferedReader(new FileReader(fileName));
           String sCurrentLine;
           while ((sCurrentLine = br.readLine()) != null){
               String newAnagram = sortWordLetters(sCurrentLine);
               anagramMap.put(sCurrentLine, newAnagram);
       	   }
       }
       catch (FileNotFoundException exc) {
           System.out.println("File not found: " + fileName);
       }
   }


   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    *
    */
   public ArrayList<String> getAnagramsOf(String s) {

       ArrayList<String> anagramsList = new ArrayList<String>();

       String newS = sortWordLetters(s);

       for (Map.Entry<String, String> entry: anagramMap.entrySet()) {
           if(entry.getValue().equals(newS)){
               anagramsList.add(entry.getKey());
           }
       }
       return anagramsList;
   }

   //sort a word in letter alphabetical order
   public String sortWordLetters(String s){
       String newAnagram = "";
       int l = s.length();
       ArrayList<String> letters = new ArrayList<String>();
       for(int i = 0; i < l; i++){
           letters.add(s.substring(i,i+1));
       }
       Collections.sort(letters);
       for(int i = 0; i < l; i++){
           newAnagram += letters.get(i);
       }
       return newAnagram;
   }
}
