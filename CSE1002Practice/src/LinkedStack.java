public class LinkedStack<T> {

    public class Node{
        private T data;
        private Node next;

        private Node(T dataPortion){
            this.data = dataPortion;
            this.next = null;
        }
    }
    private Node top;

    public void push(T entry){
        Node freshNode = new Node(entry);
        freshNode.next = this.top;
        this.top = freshNode;
    }

    public T pop(){
        T toReturn = this.top.data;
        this.top = this.top.next;
        return toReturn;
    }

    public T peek(){
        return this.top.data;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public void clear(){
        this.top = null;
    }

}
