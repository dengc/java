// Name:Chufan Deng
// USC NetID: chufande
// CS 455 PA4
// Spring 2017

import java.io.*;
import java.util.*;

public class ScoreTable {

    Map<String, Integer> scores;

    public ScoreTable(){
        scores = new HashMap<String, Integer>();

        scores.put("a",1);
        scores.put("b",3);
        scores.put("c",3);
        scores.put("d",2);
        scores.put("e",1);
        scores.put("f",4);
        scores.put("g",2);
        scores.put("h",4);
        scores.put("i",1);
        scores.put("j",8);
        scores.put("k",5);
        scores.put("l",1);
        scores.put("m",3);
        scores.put("n",1);
        scores.put("o",1);
        scores.put("p",3);
        scores.put("q",10);
        scores.put("r",1);
        scores.put("s",1);
        scores.put("t",1);
        scores.put("u",1);
        scores.put("v",4);
        scores.put("w",4);
        scores.put("x",8);
        scores.put("y",4);
        scores.put("z",10);
    }

    //get score for each letter
    public int getScore(String s){
        return scores.get(s);
    }

    //get score for a word
    public int getWordScore(String word){
        int score =0;
        for(int i=0; i<word.length(); i++){
            score += getScore(word.substring(i,i+1));
        }
        return score;
    }
}
