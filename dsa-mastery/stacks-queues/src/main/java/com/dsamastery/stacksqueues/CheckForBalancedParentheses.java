package com.dsamastery.stacksqueues;

import java.util.*;

public class CheckForBalancedParentheses {

    /* structure of a stack node */
    static class sNode
    {
    char data;
    static class sNode *next;
    };
    /* Function to push an item to stack*/
    void push(static class sNode** top_ref, int new_data);
    /* Function to pop an item from stack*/
    int pop(static class sNode** top_ref);
    /* Returns 1 if character1 and character2 are matching left
    and right Parenthesis */
    boolean isMatchingPair(char character1, char character2)
    {
    if(character1 == '(' && character2 == ')')
    return 1;
    else if(character1 == '{' && character2 == '}')
    return 1;
    else if(character1 == '[' && character2 == ']')
    return 1;
    else
    return 0;
    }
    /*Return 1 if expression has balanced Parenthesis */
    boolean areParenthesisBalanced(char exp[])
    {
    int i = 0;
    /* Declare an empty character stack */
    static class sNode *stack = null;
    /* Traverse the given expression to check matching parenthesis */
    while(exp[i])
    {
    /*If the exp[i] is a starting parenthesis then push it*/
    if(exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
    push(&stack, exp[i]);
    /* If exp[i] is a ending parenthesis then pop from stack and
    check if the popped parenthesis is a matching pair*/
    if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
    {
    /*If we see an ending parenthesis without a pair then return false*/
    if(stack == null)
    return 0;
    /* Pop the top element from stack, if it is not a pair
    parenthesis of character then there is a mismatch.
    This happens for expressions like {(}) */
    else if ( !isMatchingPair(pop(&stack), exp[i]) )
    return 0;
    }
    i++;
    }
    /* If there is something left in expression then there is a starting
    parenthesis without a closing parenthesis */
    if(stack == null)
    return 1; /*balanced*/
    else
    return 0; /*not balanced*/
    }
    /* UTILITY FUNCTIONS */
    /*driver program to test above functions*/
    int main()
    {
    char exp[100] = "{()}[]";
    if(areParenthesisBalanced(exp))
    System.out.printf("\n Balanced ");
    else
    System.out.printf("\n Not Balanced "); \
    getchar();
    }
    /* Function to push an item to stack*/
    void push(static class sNode** top_ref, int new_data)
    {
    /* allocate node */
    static class sNode* new_node =
    (static class sNode*) malloc(sizeof(static class sNode));
    if(new_node == null)
    {
    System.out.printf("Stack overflow \n");
    getchar();
    exit(0);
    }
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*top_ref);
    /* move the head to point to the new node */
    (*top_ref) = new_node;
    }
    /* Function to pop an item from stack*/
    int pop(static class sNode** top_ref)
    {
    char res;
    static class sNode *top;
    /*If stack is empty then error */
    if(*top_ref == null)
    {
    System.out.printf("Stack overflow \n");
    getchar();
    exit(0);
    }
    else
    {
    top = *top_ref;
    res = top.data;
    *top_ref = top.next;
    free(top);
    return res;
    }
    }
}
