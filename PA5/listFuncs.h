// Name: Chufan Deng
// Loginid: chufande
// CSCI 455 PA5
// Spring 2017


//*************************************************************************
// Node class definition
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

// initiate a linklist
void initList(ListType &list);

// insert a node in a linklist
bool insertFront(ListType &list, string key, int value);

// print all data of a linklist
void printList(ListType list);

// get the value of the corresponding key
int *listLookup(ListType list, string key);

// remove a node from a list
bool listRemove(ListType &list, string key);

// change the value of the corresponding key from a list
bool changeValue(ListType &list, string key, int value);

// get the size of a linklist
int listLength(ListType list);


// keep the following line at the end of the file
#endif
