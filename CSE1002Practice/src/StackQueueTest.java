public class StackQueueTest
{
    public static void main(String[] args) {
        testStackOps();
        System.out.println();
        System.out.println();
        testQueueOps();
    }

    public static void testStackOps() {
        System.out.println("STRING STACKS:");
        LinkedStack<String> myStack = new LinkedStack<String>();
        //Test pushing, peeking, and clearing
        myStack.push("Barry");
        myStack.push("Penny");
        System.out.println("Top of stack is (should be Penny): " + myStack.peek());
        myStack.clear();
        System.out.println("Stack is clear (should be true): " + myStack.isEmpty());
        //Test pushing, peeking and popping
        myStack.push("Hailey");
        myStack.push("Alma");
        myStack.push("Tyson");
        System.out.println("\nTop of stack (should be Tyson): " + myStack.peek());
        System.out.println("Pop and print stack (in this order: Tyson Alma Hailey):");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();

        System.out.println("\nINTEGER STACKS:");
        LinkedStack<Integer> myIntStack = new LinkedStack<Integer>();
        //Test pushing, peeking, and clearing
        myIntStack.push(5);
        myIntStack.push(3);
        System.out.println("Top of stack is (should be 3): " + myIntStack.peek());
        myIntStack.clear();
        System.out.println("Stack is clear (should be true): " + myIntStack.isEmpty());
        //Test pushing, peeking and popping
        myIntStack.push(12);
        myIntStack.push(-5);
        myIntStack.push(42);
        System.out.println("\nTop of stack (should be 42): " + myIntStack.peek());
        System.out.println("Pop and print stack (in this order: - 42 -5 12):");
        while (!myIntStack.isEmpty()) {
            System.out.print(myIntStack.pop() + " ");
        }
        System.out.println();
    }

    public static void testQueueOps() {
        System.out.println("STRING QUEUES:");
        LinkedQueue<String> myQueue = new LinkedQueue<String>();
        //Test enqueueing, peeking, and clearing
        myQueue.enqueue("Barry");
        myQueue.enqueue("Penny");
        System.out.println("Front of Queue is (should be Barry): " + myQueue.getFront());
        myQueue.clear();
        System.out.println("Queue is clear (should be true): " + myQueue.isEmpty());
        //Test enqueueing, peeking and popping
        myQueue.enqueue("Hailey");
        myQueue.enqueue("Alma");
        myQueue.enqueue("Tyson");
        System.out.println("\nFront of Queue (should be Hailey): " + myQueue.getFront());
        System.out.println("Dequeue and print Queue (in this order: Hailey Alma Tyson):");
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.dequeue() + " ");
        }
        System.out.println();

        System.out.println("\nINTEGER QUEUES:");
        LinkedQueue<Integer> myIntQueue = new LinkedQueue<Integer>();
        //Test enqueueing, peeking, and clearing
        myIntQueue.enqueue(5);
        myIntQueue.enqueue(3);
        System.out.println("Front of Queue is (should be 5): " + myIntQueue.getFront());
        myIntQueue.clear();
        System.out.println("Queue is clear (should be true): " + myIntQueue.isEmpty());
        //Test enqueueing, peeking and popping
        myIntQueue.enqueue(12);
        myIntQueue.enqueue(-5);
        myIntQueue.enqueue(42);
        System.out.println("\nFront of Queue (should be 12): " + myIntQueue.getFront());
        System.out.println("Dequeue and print Queue (in this order: 12 -5 42):");
        while (!myIntQueue.isEmpty()) {
            System.out.print(myIntQueue.dequeue() + " ");
        }
        System.out.println();
    }
}