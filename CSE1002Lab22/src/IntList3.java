
/**
 * A LinkedList implementation of a modified list that only holds positive ints
 * Only operations available are add (to end), contains, and toString
 * Students will code isSorted, numMatches, and bigDiff
 *
 * @author (Nicholas Welsh CSE 1002)
 * @version (Based on Linked List implementation by Carrano and Henry)
 */
public  class IntList3 {
    Node first; // points to first node in linked list
    Node last; // points to last node in linked list
    int length; // keeps track of number of nodes in the linked list
    
    // Constructor for integer list
    public IntList3() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }
    
    // Add an entry to the end of the integer list
    public void add(int entry) {
        if (this.length == 0) {  // Special case for adding first node in the list
            this.first = new Node(entry); // create new node for new entry
            this.last = this.first;  // in this case, the first node is also the last node
        }
        else {
            Node temp = new Node(entry);  // create new node for new entry
            this.last.next = temp;
            this.last = temp;
        }
        this.length++;
     }
    
   // Determines whether an entry is in the lst
   public boolean contains(int entry) {
        Node current = this.first; // current will keep track of the node we are currently processing
        
        // iterate through the linked list, looking for the entry
        while(current != null) {
            if (current.data == entry) return true;
            current = current.next;
        }
        
        // if not found, return false
        return false;
   }
   
   /* Replace the data  in each node with its value modulo n
    * So, if the list is 5 8 11 9 14 and n is 4, the modified list 
    * should be 1 0 3 1 2 
    */
   public void moduloN(int n) {
        Node current = this.first;
        while(current != null){
            current.data %= n; // current.data = current.data % n;
            current = current.next;
        }
        
       //Alternative way (still the same)
     /* for(Node current = this.first; current != null; current = current.next){
            current.data = current.data.next;
        }
     */
   }
   
   /* Take the average of all values, excluding the largest and smallest values 
    * So 3 7 2 9 5 would return 5 (remove 2 and 9 and average 3 7 and 5)
      Assume more than two items in the list */  
   public int centeredAverage() {
       Node current = this.first;
       int largestNum = this.first.data;
       int smallestNum = this.first.data;
       int sum = 0;
       int numInSum = 0;
       while(current != null){
           if(current.data > largestNum){
               largestNum = current.data;
           } else if(current.data < smallestNum) {
               smallestNum = current.data;
           }
           sum += current.data;
           numInSum++;
           current = current.next;
       }
       // take largest/smallest numbers out of the amount to be divided
       sum -= (largestNum+smallestNum);
       numInSum -= 2;

       return sum/numInSum; // returns average
   }
   
   /* Return the largest difference between any two adjacent values.  So if the list is 
    * 1 5 6 11 4 7 12, the method should return 7, because the largest difference in this case is between
    * the 11 and the  4 in the list.
    */
   public int biggestStep() {
        Node current = this.first;
        int bestDifference = 0;
        while(current != this.last){
            int currentDifference = Math.abs(current.data - current.next.data);

            if(currentDifference > bestDifference){
                bestDifference = currentDifference;
            }

            current = current.next;
        }
        return bestDifference;
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
   
   // Innder Node class 
   private class Node {
       Node next;
       int data;
       
       // Default constructor for a Node - set data to -1000 (assumption is Nodes only contain positive ints)
       private Node() {
           this.next = null;
           this.data = -1000;
       }
       
       // Value constructor for a Node, where we specify the data to go inot the Node
       private Node(int entry) {
           this.next = null;
           this.data = entry;
       }
   }
    
   public static void main(String[] args) {
       IntList3 myList1 = new IntList3();
       //Add items to int list
       myList1.add(5);
       myList1.add(6);
       myList1.add(8);
       myList1.add(11);
       myList1.add(100);
       myList1.add(15);
       
       IntList3 myList2 = new IntList3();
       myList2.add(7);
       myList2.add(6);
       myList2.add(8);
       myList2.add(11);
       myList2.add(100);
       myList2.add(103);
       
       IntList3 myList3 = new IntList3();
       myList3.add(7);
       myList3.add(6);
       myList3.add(6);
       myList3.add(8);
       myList3.add(8);
       myList3.add(8);
       myList3.add(2);
       myList3.add(6);
       
       IntList3 myList4 = new IntList3();
       myList4.add(7);
       myList4.add(6);
       myList4.add(22);
       myList4.add(11);
       myList4.add(13);
       myList4.add(13);
       
       IntList3 myList5 = new IntList3();
       myList5.add(6);
       myList5.add(8);
       myList5.add(11);
       myList5.add(100);
       myList5.add(103);
       
       
       System.out.println("myList1: " + myList1);
       System.out.println("myList2: " + myList2);
       System.out.println("myList3: " + myList3);
       System.out.println("myList4: " + myList4);
       System.out.println("myList5: " + myList5);
       
       System.out.println("\nTesting moduloN --------------");
       myList1.moduloN(3);
       System.out.println("new myList1 (modulo 3): " + myList1);
       if (myList1.toString().trim().equals("2 0 2 2 1 0")) System.out.println("myList1 PASS PASS PASS");
       else System.out.println("myList1 FAIL");
       
       myList2.moduloN(4);
       System.out.println("\nnew myList2 (modulo 4): " + myList2);
       if (myList2.toString().trim().equals("3 2 0 3 0 3")) System.out.println("myList2 PASS PASS PASS");
       else System.out.println("myList2 FAIL");
       
       System.out.println("\nTesting biggestStep --------------");
       System.out.println("Biggest step in mylist3 is (should be 6): " + myList3.biggestStep());
       if (myList3.biggestStep() == 6) System.out.println("myList3 PASS PASS PASS");
       else System.out.println("myList3 FAIL");
       
       System.out.println("\nBiggest step in myList4 is (should be 16): " + myList4.biggestStep());
       if (myList4.biggestStep() == 16) System.out.println("myList4 PASS PASS PASS");
       else System.out.println("myList4 FAIL");
       
       System.out.println("\nBiggest step in myList5 is (should be 89): " + myList5.biggestStep());
       if (myList5.biggestStep() == 89) System.out.println("myList4 PASS PASS PASS");
       else System.out.println("myList5 FAIL");
    
       System.out.println("\nTesting centeredAverage --------------");
       System.out.println("Centered average of myList3 is (should be 6): " +  myList3.centeredAverage());
       if (myList3.centeredAverage() == 6) System.out.println("myList3 PASS PASS PASS");
       else System.out.println("myList3 FAIL");
       
       System.out.println("\nCentered average of myList4 is (should be 11): " +  myList4.centeredAverage());
       if (myList4.centeredAverage() == 11) System.out.println("myList4 PASS PASS PASS");
       else System.out.println("myList4 FAIL");
       
       System.out.println("\nCentered average of myList5 is (should be 39): " +  myList5.centeredAverage());
       if (myList5.centeredAverage() == 39) System.out.println("myList5 PASS PASS PASS");
       else System.out.println("myList5 FAIL");
    }
}
