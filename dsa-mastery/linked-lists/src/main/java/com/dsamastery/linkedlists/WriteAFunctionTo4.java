package com.dsamastery.linkedlists;

import java.util.*;

public class WriteAFunctionTo {

    Method 1(Simply use two loops)
    Method 2 (Mark Visited Nodes)
    Method 3(Using diﬀerence of node counts)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to get the counts of node in a linked list */
    int getCount(static class node* head);
    /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    int _getIntesectionNode(int d, static class node* head1, static class node* head2);
    /* function to get the intersection point of two linked
    lists head1 and head2 */
    int getIntesectionNode(static class node* head1, static class node* head2)
    {
    int c1 = getCount(head1);
    int c2 = getCount(head2);
    int d;
    if(c1 > c2)
    {
    d = c1 - c2;
    return _getIntesectionNode(d, head1, head2);
    }
    else
    {
    d = c2 - c1;
    return _getIntesectionNode(d, head2, head1);
    }
    }
    /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    int _getIntesectionNode(int d, static class node* head1, static class node* head2)
    {
    int i;
    static class node* current1 = head1;
    static class node* current2 = head2;
    for(i = 0; i < d; i++)
    {
    if(current1 == null)
    { return -1; }
    current1 = current1.next;
    }
    while(current1 != null && current2 != null)
    {
    if(current1 == current2)
    return current1.data;
    current1= current1.next;
    current2= current2.next;
    }
    return -1;
    }
    /* Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(static class node* head)
    {
    static class node* current = head;
    int count = 0;
    while (current != null)
    {
    count++;
    current = current.next;
    }
    return count;
    }
    /* IGNORE THE BELOW LINES OF CODE. THESE LINES
    ARE JUST TO QUICKLY TEST THE ABOVE FUNCTION */
    int main()
    {
    /*
    Create two linked lists
    1st 3.6.9.15.30
    2nd 10.15.30
    15 is the intersection point
    */
    static class node* newNode;
    static class node* head1 =
    (static class node*) malloc(sizeof(static class node));
    head1.data = 10;
    static class node* head2 =
    (static class node*) malloc(sizeof(static class node));
    head2.data = 3;
    newNode = (static class node*) malloc (sizeof(static class node));
    newNode.data = 6;
    head2.next = newNode;
    newNode = (static class node*) malloc (sizeof(static class node));
    newNode.data = 9;
    head2.next.next = newNode;
    newNode = (static class node*) malloc (sizeof(static class node));
    newNode.data = 15;
    head1.next = newNode;
    head2.next.next.next = newNode;
    newNode = (static class node*) malloc (sizeof(static class node));
    newNode.data = 30;
    head1.next.next= newNode;
    head1.next.next.next = null;
    System.out.printf("\n The node of intersection is %d \n",
    getIntesectionNode(head1, head2));
    getchar();
    }
    Method 4(Make circle in ﬁrst list)
    Method 5 (Reverse the ﬁrst list and make equations)
    X + Z = C1;
    Y + Z = C2;
    X = (C1 + C3 – C2)/2;
    Y = (C2 + C3 – C1)/2;
    Z = (C1 + C2 – C3)/2;
    Method 7 (Use Hashing)
}
