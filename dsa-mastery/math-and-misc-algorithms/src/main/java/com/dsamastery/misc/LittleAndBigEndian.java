package com.dsamastery.misc;

import java.util.*;

public class LittleAndBigEndian {

    /* function to show bytes in memory, from location start to start+n*/
    void show_mem_rep(char *start, int n)
    {
    int i;
    for (i = 0; i < n; i++)
    System.out.printf(" %.2x", start[i]);
    System.out.printf("\n");
    }
    /*Main function to call above function for 0x01234567*/
    int main()
    {
    int i = 0x01234567;
    show_mem_rep((char *)&i, sizeof(i));
    getchar();
    return 0;
    }
    int main()
    {
    unsigned int i = 1;
    char *c = (char*)&i;
    if (*c)
    System.out.printf("Little endian");
    else
    System.out.printf("Big endian");
    getchar();
    return 0;
    }
    int main()
    {
    unsigned char arr[2] = {0x01, 0x00};
    unsigned short int x = *(unsigned short int *) arr;
    System.out.printf("%d", x);
    getchar();
    return 0;
    }
}
