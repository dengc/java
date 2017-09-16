// Name:Chufan Deng
// USC NetID: chufande
// CS 455 PA4
// Spring 2017

import java.io.*;
import java.util.*;

public class WordFinder {

    public static void main(String[] args) throws IOException {

        //if there is no file name typed
        if (args.length < 1) {
           System.out.println("ERROR: missing file name command line argument");
           return;
        }
        //start the program
        System.out.println("Type . to quit.");
        System.out.print("Rack?  ");
        Scanner in = new Scanner(System.in);

        if(in.hasNext()){
            String rack = in.next();
            while(!rack.equals(".")){
                //for storing all subnet words
                Set<String> result = new HashSet<String>();
                //for storing words and scores
                Map<String, Integer> resultMap = new HashMap<String, Integer>();

                Rack newRack = new Rack(rack);
                AnagramDictionary newAD = new AnagramDictionary(args[0]);

                result = storeResultWords(newRack, newAD);

                System.out.println("We can make "+ result.size() +" words from " + "\"" + newRack.getSubnets().get(newRack.getSubnets().size()-1) + "\"");
                System.out.println("All of the words with their scores (sorted by score):");

                storeWordsScores(result,resultMap);

                //sort the answer
                List<Map.Entry<String, Integer>> list = new LinkedList<>( resultMap.entrySet() );
                Collections.sort(list, new mapValueCompare());
                printMapList(list);

                System.out.print("Rack?  ");
                rack = in.next();
            }
        }

    }

    //print maplist
    public static void printMapList(List<Map.Entry<String, Integer>> list){
        for(Map.Entry<String, Integer> entry: list){
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    //store all words
    public static Set<String> storeResultWords(Rack r, AnagramDictionary ad){
        Set<String> result = new HashSet<String>();
        for(String subs : r.getSubnets()){
            if(!ad.getAnagramsOf(subs).isEmpty()){
                for(String outputs : ad.getAnagramsOf(subs)){
                    result.add(outputs);
                }
            }
        }
        return result;
    }

    //store words and their scores
    public static void storeWordsScores(Set<String> result, Map<String, Integer> resultMap){
        for(String s: result){
            int score = 0;
            String resultRow = "";
            ScoreTable scores = new ScoreTable();

            score = scores.getWordScore(s);

            resultMap.put(s, score);
        }
    }
}

//compare keys after comparing values: to make words in alphabetical order if having same scores
class mapValueCompare implements Comparator<Map.Entry<String,Integer>>{

    public int compare(Map.Entry<String,Integer> map1, Map.Entry<String,Integer> map2) {

        if(map2.getValue() == map1.getValue()){
            return (map1.getKey()).compareTo(map2.getKey());
        }
        return map2.getValue() - map1.getValue();
   }
}
