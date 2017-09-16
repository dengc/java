// Name: Chufan Deng
// Loginid: chufande
// CSCI 455 PA5
// Spring 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 *
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>
#include <string>
#include <vector>
#include <functional>
#include <iostream>

bool split(const string& s, char c, vector<string>& v);

int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number"
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);


  bool keepgoing = true;

  while(keepgoing){
      string input = "";
      vector<string> command;  // store the spliting info

      cout << "cmd> ";
      getline(cin, input);

      if(input == "print"){
          grades->printAll();
      }
      else if(input == "size"){
          cout << grades->numEntries() << endl;
      }
      else if(input == "stats"){
          grades->hashStats(cout);
      }
      else if(input == "help"){
          cout << "Please enter a command [insert name score, change name newscore, lookup name, remove name, print, size, stats, quit]: " << endl;
      }
      else if(input == "quit"){
          keepgoing = false;
      }
      else if(split(input, ' ', command)){
          if(command[0] == "insert"){
              if(!grades->insert(command[1], atoi(command[2].c_str()))){
                  cout << "There is a same name exists!" << endl;
              }
          }
          else if(command[0] == "change"){
              if(!grades->change(command[1], atoi(command[2].c_str()))){
                  cout << "There is no such name!" << endl;
              }
          }
          else if(command[0] == "lookup"){
              if(grades->lookup(command[1]) != NULL){
                  cout << *grades->lookup(command[1]) << endl;
              }
              else{
                  cout << "No such name!" << endl;
              }
          }
          else if(command[0] == "remove"){
              if(!grades->remove(command[1])){
                  cout << "No such name!" << endl;
              }
          }
          else{
              cout << "ERROR: invalid command! See Help Command!" << endl;
          }
      }
      else{
          cout << "ERROR: invalid command! See Help Command!" << endl;
      }
  }

  return 0;
}

// split a string into a vector
bool split(const string& s, char c, vector<string>& v) {
   string::size_type i = 0;
   string::size_type j = s.find(c);

   if(j == string::npos){
       return false;
   }

   while (j != string::npos) {
      v.push_back(s.substr(i, j-i));
      i = ++j;
      j = s.find(c, j);

      if (j == string::npos){
          v.push_back(s.substr(i, s.length()));
      }
   }
   return true;
}
