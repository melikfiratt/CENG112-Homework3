package HW3;

public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>{

    private Node firstNode;
    private int numberOfEntries;

    public PriorityQueue(){
        firstNode=null;
        numberOfEntries=0;
    }

    private class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public int compareTo(Node other1,Node other2) {
        Task o1=(Task) other1.data;
        Task o2=(Task) other2.data;
        return o1.PriorityCompareTo(o2);
    }

    @Override
    public void add(T newEntry) {
        Node newNode=new Node(newEntry);
        if (isEmpty() || compareTo(newNode,firstNode)>0){
            newNode.next=firstNode;
            firstNode=newNode;
        }else{
            Node current=firstNode;
            while (current.next != null && compareTo(newNode,current.next) > 0) {
                current = current.next;
            }
            newNode.next=current.next;
            current.next=newNode;
        }

        numberOfEntries++;
    }

   

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return firstNode.data;
    }

    @Override
    public boolean isEmpty() {
        return firstNode==null;
    }
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data=firstNode.data;
        firstNode=firstNode.next;
        numberOfEntries--;
        return data;
    }

    @Override
    public int getSize() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }
}
