// Name: Chufan Deng
// Loginid: chufande
// CSCI 455 PA5
// Spring 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
    key = theKey;
    value = theValue;
    next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
    key = theKey;
    value = theValue;
    next = n;
}

//*************************************************************************
// put the function definitions for your list functions below

void initList(ListType &list) {
    list = NULL;
}

bool insertFront(ListType &list, string key, int value){
    // if the name already exists
    if(list!= NULL){
        for (Node *p = list; p != NULL; p = p->next) {
            if(p->key == key){
                return false;
            }
        }
    }
    Node *newNode = new Node(key, value, list);
    list = newNode;

    return true;
}

void printList(ListType list){
    if (list == NULL) {
        cout << "<empty>";
    }

    for (Node *p = list; p != NULL; p = p->next) {
      cout << p->key << " " << p->value;
      cout << endl;
    }
}

int *listLookup(ListType list, string key){
    if (list == NULL) {
        return NULL;
    }

    for (Node *p = list; p != NULL; p = p->next) {
        if(p->key == key){
            return &p->value;
        }
    }

    return NULL;
}

bool listRemove(ListType &list, string key){
    if (list == NULL) {
        return false;
    }
    // if the head is the node to be removed
    if (list->key == key) {
        delete list;
        list = list->next;
        return true;
    }

    for (Node *p = list; p != NULL; p = p->next) {
        if(p->next != NULL){
            if(p->next->key == key){
                Node *newP = p->next->next;
                delete p->next;
                p->next = newP;
                return true;
            }
        }
    }
    return false;
}

bool changeValue(ListType &list, string key, int value){
    if(listLookup(list, key)){
        *listLookup(list, key) = value;
        return true;
    }
    return false;
}

int listLength(ListType list){
    int length = 0;
    for (Node *p = list; p != NULL; p = p->next) {
        length++;
    }
    return length;
}
