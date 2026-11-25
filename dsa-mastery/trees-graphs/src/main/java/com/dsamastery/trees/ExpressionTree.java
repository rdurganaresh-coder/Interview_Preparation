package com.dsamastery.trees;

import java.util.*;

public class ExpressionTree {

    // calculate applies operator 't.value'
    // on A and B, and returns value
    Return calculate(A, B, t.value)
    // C++ program for expression tree
    // An expression tree node
    static class et
    {
    char value;
    et* left, *right;
    };
    // A utility function to check if 'c'
    // is an operator
    boolean isOperator(char c)
    {
    if (c == '+' || c == '-' ||
    c == '*' || c == '/' ||
    c == '^')
    return true;
    return false;
    }
    // Utility function to do inorder traversal
    void inorder(et *t)
    {
    if(t)
    {
    inorder(t.left);
    System.out.printf("%c ", t.value);
    inorder(t.right);
    }
    }
    // A utility function to create a new node
    et* newNode(int v)
    {
    et *temp = new et;
    temp.left = temp.right = null;
    temp.value = v;
    return temp;
    };
    // Returns root of constructed tree for given
    // postfix expression
    et* constructTree(char postfix[])
    {
    stack<et *> st;
    et *t, *t1, *t2;
    // Traverse through every character of
    // input expression
    for (int i=0; i<strlen(postfix); i++)
    {
    // If operand, simply push into stack
    if (!isOperator(postfix[i]))
    {
    t = newNode(postfix[i]);
    st.push(t);
    }
    else // operator
    {
    t = newNode(postfix[i]);
    // Pop two top nodes
    t1 = st.top(); // Store top
    st.pop(); // Remove top
    t2 = st.top();
    st.pop();
    // make them children
    t.right = t1;
    t.left = t2;
    // Add this subexpression to stack
    st.push(t);
    }
    }
    // only element will be root of expression
    // tree
    t = st.top();
    st.pop();
    return t;
    }
    // Driver program to test above
    int main()
    {
    char postfix[] = "ab+ef*g*-";
    et* r = constructTree(postfix);
    System.out.printf("infix expression is \n");
    inorder(r);
    return 0;
    }
}
