//generalized form of a Stack
public class LinkedStack<T> {
    private class LSNode{
        private T data;
        private LSNode next;


        private LSNode(T dataPortion){
            this.data = dataPortion;
            this.next = null;
        }
    }
    private LSNode top;

    public void push(T entry){
        LSNode freshNode = new LSNode(entry);
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
        //thank God for garbage collection
        this.top = null;
    }

}
