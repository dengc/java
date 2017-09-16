// Name: Chufan Deng
// Loginid: chufande
// CSCI 455 PA5
// Spring 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// declare a table
Table::Table() {
    hashSize = HASH_SIZE;
    data = new ListType[HASH_SIZE];
    for (int i = 0; i < HASH_SIZE; i++){
        initList(data[i]);
    }
    numEntry = 0;
}

// declare a table with a size
Table::Table(unsigned int hSize) {
    hashSize = hSize;
    data = new ListType[hSize];
    for (int i = 0; i < hSize; i++){
        initList(data[i]);
    }
    numEntry = 0;
}

// lookup the score of a name
int * Table::lookup(const string &key) {
    for (int i = 0; i < hashSize; i++){
        if(listLookup(data[i],key) != NULL){
            return listLookup(data[i],key);
        }
    }
    return NULL;
}

// remove a node from the table
bool Table::remove(const string &key) {
    for (int i = 0; i < hashSize; i++){
        if(listRemove(data[i],key)){
            numEntry--;
            return true;
        }
    }
    return false;
}

// insert a pair of name and score
bool Table::insert(const string &key, int value) {
    int hash = hashCode(key);
    if(insertFront(data[hash],key,value)){
        numEntry++;
        return true;
    }
    return false;
}

// change the score of corresponding name
bool Table::change(const string &key, int value) {
    int hash = hashCode(key);
    return changeValue(data[hash], key, value);
}

// return the number of entries
int Table::numEntries() const {
    return numEntry;
}

// print out all the data in the table
void Table::printAll() const {
    for (int i = 0; i < hashSize; i++){
        if(data[i] != NULL){
            printList(data[i]);
        }
    }
}

// print the table stats
void Table::hashStats(ostream &out) const {
    out << "number of buckets: " << hashSize << endl;
    out << "number of entries: " << numEntry << endl;

    int nonEmptyBucket = 0;
    int longestChain = 0;
    int num = 0;
    // get the numbers of non-empty buckets and the longest Chain
    for (int i = 0; i < hashSize; i++){
        if(data[i] != NULL){
            nonEmptyBucket++;
            num = listLength(data[i]);
            if(num > longestChain){
                longestChain = num;
            }
        }
    }

    out << "number of non-empty buckets: " << nonEmptyBucket << endl;
    out << "longest chain: " << longestChain << endl;
}
