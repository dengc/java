/*  Name: Chufan Deng
 *  USC NetID: chufande
 *  CS 455 Spring 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int lastIndexOf(ListType list, int val) {
    int index = -1;
    int count = 0;
    ListType p = list;

    while(p != NULL){
        if(p->data == val){
            index = count;
        }
        p = p->next;
        count++;
    }
    return index;
}



void removeFollowingEvens(ListType &list) {
    ListType p = list;
    ListType r = list;
    while(p != NULL){
        if(p->data % 2 == 0){
            r = p->next;
            while(r != NULL && r->data % 2 == 0){
                r = p->next->next;
                delete p->next;
                p->next = r;
            }
        }
        p = p->next;
    }
}



void mirrorList(ListType & list) {
    ListType p = list;
    ListType r = NULL;
    while (p != NULL) {
        r = new Node(p->data, r);
        if(p->next == NULL){
            break;
        }
        p = p->next;
    }
    if(p != NULL){
        p->next = r;
    }
}



void rotateRight(ListType &list, int k) {
    if(k<=0 || list == NULL){
        return;
    }
    ListType p = list;
    ListType r = p;
    int size = 0;
    while (r != NULL) {
        size++;
        r = r->next;
    }
    int rotate = size - k;
    if(k < size && k > 0){
        for (int i = 0; i < rotate; i++) {
            list = list->next;
        }
    }
    r = list;
    while (r->next != NULL) {
        r = r->next;
    }
    for (int i = 0; i < rotate; i++) {
        r->next = new Node(p->data);
        p = p->next;
        r = r->next;
    }
}
