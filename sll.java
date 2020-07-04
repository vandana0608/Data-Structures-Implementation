//Single Linked List implementation in JAVA
import java.io.*;
public class sll {
    Node head; //head pointer
    static class Node   //static class to define node with data and link; static used as it can accessed by main class sll
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static sll insert (sll list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
        // If the Linked List is empty, then make the new node as head
        if (list.head == null)
        {
            list.head = new_node;
        }
        else
        {
            // Else traverse till the last node and insert the new_node there
            Node last = list.head;
            while (last.next != null)
            {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
        // Return the list by head
        return list;
    }
    public static void display(sll list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null)
        {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }
    public static sll deletebykey(sll list, int key)    //deletion by key (data)
    {
        Node currNode = list.head, prev = null; // Store head node
        // CASE 1: If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key)
        {
            list.head = currNode.next; // Changed head
            System.out.println(key + " found and deleted");
            return list;
        }
        // CASE 2: If the key is somewhere other than at head, Search for the key to be deleted, keep track of the previous node as it is needed to change currNode.next
        while (currNode != null && currNode.data != key)
        {
            prev = currNode;    // If currNode does not hold key continue to next node
            currNode = currNode.next;
        }
        // If the key was present, it should be at currNode thus the currNode shall not be null
        if (currNode != null)
        {
            prev.next = currNode.next;  // Since the key is at currNode unlink currNode from linked list
            System.out.println(key + " found and deleted");
        }
        // CASE 3: The key is not present then currNode should be null
        if (currNode == null)
        {
            System.out.println(key + " not found");
        }
        return list;
    }
    public static sll deletebyposition(sll list, int index)
    {
        Node currNode = list.head, prev = null; // Store head node
        // CASE 1: If index is 0, then head node itself is to be deleted
        if (index == 0 && currNode != null)
        {
            list.head = currNode.next; // Changed head
            System.out.println(index + " position element deleted");
            return list; 
        }
        // CASE 2: If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;
        // Count for the index to be deleted, keep track of the previous node as it is needed to change currNode.next
        while (currNode != null)
        {
            if (counter == index)
            {
                // Since the currNode is the required position unlink currNode from linked list
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            }
            else
            {
                // If current position is not the index continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        // If the position element was found, it should be at currNode thus the currNode shall not be null
        // CASE 3: The index is greater than the size of the LinkedList the currNode should be null
        if (currNode == null)
        {
            System.out.println(index + " position element not found");
        }
        return list;
    }
    public static void main(String args[]) throws IOException
    {
        sll list = new sll();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        display(list);
        deletebykey(list, 1);
        display(list);
        deletebykey(list, 8);
        display(list);
        deletebykey(list, 4);
        display(list);
        deletebyposition(list, 1);
        display(list);
    }
}