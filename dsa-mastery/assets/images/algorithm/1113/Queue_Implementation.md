# Queue_Implementation

> **Original PDF:** [Queue_Implementation.pdf](./Queue_Implementation.pdf) | **Jump to Java Code:** [Project Root](..)

---

1 null head 2 null enqueue 1 1 next tail enqueue 2 21 next tail enqueue 3 3 null 2 next1 next head dequeue 3 null Get value of the head node, let the head pointer point to the next node.
Create new node with the given value in the tail of the list, set current tail's next pointer point to the new node and let the tail pointer point to the last node.
 
Create new node with the given value and let both the head pointer and tail pointers point to the new node.
Implement Queue with Linked List head enqueue 1 Initial capacity = 10 1 2 tail enqueue 2 1 2 3 tail enqueue 3 Implement Queue with Array head = -1, tail = -1 2 3 tail dequeue Create new array with given capacity Move both head and tail one step ahead and set value 1 Move tail one step ahead and set value 2 Move tail one step ahead and set value 3 Return the head value and move head one step ahead tail head head tail Create new node with the given value in the tail of the list, set current tail's next pointer point to the new node and let the tail pointer point to the last node.
 
next tail head head head Tail Head Circular Array head enqueue 1 Initial capacity = 10 1 2 tail enqueue 2 1 2 3 tail enqueue 3,4,5,6,7,8 Implement Queue with Circular Array head = -1, tail = -1 4 5 6 7 8 2 3 tail dequeue 4 5 6 7 8 Create new array with given capacity Move both head and tail one step ahead and set value 1 Move tail one step ahead and set value 2 Return the head value and move head one step ahead tail head head head 9 3 tail enqueue 9 4 5 6 7 8 Reset tail if it reaches to the end head tail dequeue 4 5 6 7 8 Return the head value and move head one step ahead head Queue is full, can't add more items 9 10 tail dequeue 3,4,5,6,7 8 head 9 10 3 tail enqueue 10 4 5 6 7 8 head Move tail one step ahead and set value 10 9 10 tail dequeue 8 head Reset head if it reaches to the end Dequeue items until head reaches to the last position