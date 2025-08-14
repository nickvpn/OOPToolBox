public class LinkedQueue<T>{

    public class Node{
        private T data;
        private Node next;

        private Node(T dataPortion){
            this.data = dataPortion;
            this.next = null;
        }
    }
    public Node front;
    public Node back;

    public void enqueue(T entry){
        Node freshNode = new Node(entry);
        if(this.isEmpty()){
            this.front = freshNode;
            this.back = freshNode;
        } else {
            this.back.next = freshNode;
            this.back = freshNode;
        }
    }

    public T dequeue(){
        if(this.isEmpty()) return null;
        T toReturn = this.front.data;
        if(this.front == this.back){
            this.front = null;
            this.back = null;
        } else this.front = this.front.next;
        return toReturn;
    }

    public T getFront(){
        return this.front.data;
    }

    public boolean isEmpty(){
        return this.front == null;
    }

    public void clear(){
        this.front = null;
        this.back = null;
    }
}
