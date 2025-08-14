/**
 * A LinkedList implementation of a modified list that only holds positive ints
 * Only operations available are add (to end), contains, and toString
 * Students will code total, switcheroo, and circShiftLeft
 *
 * @author (CSE 1002)
 * @version (Based on Linked List implementation by Carrano and Henry)
 */
public class IntList {
    Node first; // points to first node in linked list
    Node last; // points to last node in linked list
    int length; // keeps track of number of nodes in the linked list
    // Constructor for integer list
    public IntList() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }
    // Add an entry to the end of the integer list
    public void add(int entry) {
        if (this.length == 0) { // Special case for adding first node in the list
            this.first = new Node(entry); // create new node for new entry
            this.last = this.first; // in this case, the first node is also the last node
        }
        else {
            Node temp = new Node(entry); // create new node for new entry
            this.last.next = temp;
            this.last = temp;
        }
        this.length++;
    }
    // Determines whether an entry is in the list
    public boolean contains(int entry) {
        Node current = this.first; // current will keep track of the node we are currently processing
        // iterate through the linked list, looking for the entry
        while (current != null) {
            if (current.data == entry) return true;
            current = current.next;
        }
        // if not found, return false
        return false;
    }
    // Return the total of the entries in all the nodes
    public int total() {
        int sum = 0;
        Node current = this.first;
        while(current != null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    // For each pair of nodes, switch their information (i.e., switch first and second, third and fourth, etc.)
    public void switcheroo() {
        Node current = this.first;
        int temp = 0;
        while(current != null){
            temp = current.next.data;
            current.next.data = current.data;
            current.data = temp;
            current = current.next.next;
        }
    }

    /* Shift the nodes in the linked list by moving the first
    entry to the end of the list, and make the second entry the first entry
    (so, for example, 4 6 8 9 becomes 6 8 9 4) */
    public void circShiftLeft() {
        //sever head
        Node oldFirst = this.first;
        this.first = oldFirst.next;
        oldFirst.next = null;

        //add to tail
        last.next = oldFirst;
        last = oldFirst;
    }
    // Return the information in the linked list as a String
    public String toString() {
        Node current = this.first; // current will keep track of the node we are currently processing
        String stringToReturn = ""; // collect the information in stringToReturn
    // iterate through the linked list, accessing the data in the node and adding it to the String
        while (current != null) {
            stringToReturn += current.data + " ";
            current = current.next;
        }
    // return the resulting String
        return stringToReturn;
    }
    // Inner Node class
    private class Node {
        Node next;
        int data;
        // Default constructor for a Node - set data to -1000 (assumption is Node only contain positive ints)
        private Node() {
            this.next = null;
            this.data = -1000;
        }
        // Value constructor for a Node, where we specify the data to go into the Node
        private Node(int entry) {
            this.next = null;
            this.data = entry;
        }
    }
    public static void main(String[] args) {
        IntList myList = new IntList();
    //Add items to int list
        myList.add(5);
        myList.add(6);
        myList.add(8);
        myList.add(11);
        myList.add(100);
        myList.add(15);
    //Display total (145)
        System.out.println("Total in list is currently (should be 145):" +
                myList.total());
    //Display list
        System.out.println("\nCurrent list (should print 5 6 8 11 100 15)");
        System.out.println(myList);
    //Switcheroo!
        myList.switcheroo();
        System.out.println("\nSwitcheroo (should print 6 5 11 8 15 100):");
        System.out.println(myList);
    //Shift list left
        myList.circShiftLeft();
        System.out.println("\nCircular shift Left (should print 5 11 8 15 100 6): ");
                System.out.println(myList);
    //Shift list left again
        myList.circShiftLeft();
        System.out.println("\nCircular shift Left again (should print 11 8 15 100 6 5): ");
        System.out.println(myList);
    //Add two more items
        System.out.println("\nAdding two more values (40 and 60)");
        myList.add(40);
        myList.add(60);
    //Display list
        System.out.println("\nCurrent list (should print 11 8 15 100 6 5 40 60): ");
        System.out.println(myList);
    //Check new total (should be 245)
        System.out.println("\nTotal in list is currently (should be 245): " +
                myList.total());
    //Switcheroo!
        myList.switcheroo();
        System.out.println("\nSwitcheroo (should print 8 11 100 15 5 6 60 40):");
        System.out.println(myList);
    //Shift list left
        myList.circShiftLeft();
        System.out.println("\nCircular shift Left (should print 11 100 15 5 6 60 40 8): ");
        System.out.println(myList);
    }
}