package com.dsamastery.linkedlists;

import java.util.*;

public class HowToWriteC {

    void addXtoList(static class node *node, int x)
    {
    while(node != null)
    {
    node.data = node.data + x;
    node = node.next;
    }
    }
    // global head pointer
    static class node *head = null;
    // function to delete first node: uses approach 2.1
    // See http://ideone.com/ClfQB for complete program and output
    void deleteFirst()
    {
    if(head != null)
    {
    // store the old value of head pointer
    static class node *temp = head;
    // Change head pointer to point to next node
    head = head.next;
    // delete memory allocated for the previous head node
    free(temp);
    }
    }
    // function to delete first node: uses approach 2.2
    // See http://ideone.com/P5oLe for complete program and output
    static class node *deleteFirst(static class node *head)
    {
    if(head != null)
    {
    // store the old value of head pointer
    static class node *temp = head;
    // Change head pointer to point to next node
    head = head.next;
    // delete memory allocated for the previous head node
    free(temp);
    }
    return head;
    }
    // function to delete first node: uses approach 2.3
    // See http://ideone.com/9GwTb for complete program and output
    void deleteFirst(static class node **head_ref)
    {
    if(*head_ref != null)
    {
    // store the old value of pointer to head pointer
    static class node *temp = *head_ref;
    // Change head pointer to point to next node
    *head_ref = (*head_ref)->next;
    // delete memory allocated for the previous head node
    free(temp);
    }
    }
}
