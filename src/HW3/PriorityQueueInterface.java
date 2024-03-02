package HW3;

public interface PriorityQueueInterface<T extends Comparable<? super T>>{

	public int getSize();
	public void add(T newEntry);
    public T remove();
    public boolean isEmpty();
    public void clear();
    public T peek();


}
