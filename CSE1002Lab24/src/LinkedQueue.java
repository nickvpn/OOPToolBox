//generalized form of a LinkedQueue
public class LinkedQueue<T> {
    public class LQNode{
        private T data;
        private LQNode next;

        private LQNode(T dataPortion){
            this.data = dataPortion;
            this.next = null;
        }
    }

    public LQNode front;
    public LQNode back;

    public void enqueue(T entry){
        LQNode freshNode = new LQNode(entry);
        if(this.isEmpty()){
            this.front = freshNode;
            this.back = freshNode;
        } else {
            // point current node to new node
            this.back.next = freshNode;
            // make new node the new back
            this.back = freshNode;
        }
    }

    public T dequeue(){
        if(this.isEmpty()) return null;
        T toReturn = this.front.data;
        if(this.front == this.back){
            this.front = null;
            this.back = null;
        } else {
            //second in line becomes new front
            this.front = this.front.next;
        }
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
