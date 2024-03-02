package HW3;

public class BurstStack<T extends Comparable<? super T>> implements StackInterface<T>{

    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY=20;

    public BurstStack(){
        @SuppressWarnings("unchecked")
		T[] tempStack=(T[]) new Comparable[DEFAULT_CAPACITY];
        stack=tempStack;
        topIndex=-1;
    }

    public int compareTo(T other1,T other2) {
        Task o1=(Task) other1;
        Task o2=(Task) other2;
        return o1.StackCompareTo(o2);
    }

    @Override
    public void push(T newEntry) {
        int index = 0;
        while (index <= topIndex && compareTo(newEntry,stack[index]) < 0) {
            index++;
        }
        for (int i = topIndex; i >= index; i--) {
            stack[i + 1] = stack[i];
        }
        stack[index] = newEntry;
        topIndex++;
    }

    

    @Override
    public T peek() {
        if (isEmpty()){
            throw  new IllegalStateException("Stack is empty");
        }
        else{
            return stack[topIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        return topIndex==-1;
    }
    @Override
    public T pop() {
        if (isEmpty()){
            throw  new IllegalStateException("Stack is empty");
        }
        else{
            T top=stack[topIndex];
            stack[topIndex]=null;
            topIndex--;
            return top;
        }
    }
    @Override
    public void clear() {
        while(!isEmpty()){
            pop();
        }
    }
}
