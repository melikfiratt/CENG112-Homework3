package HW3;

public interface SortedListInterface<T extends Comparable<? super T>>{
	public void add(T newEntry);
	public boolean remove(T anEntry);
	public int getPosition(T anEntry);
	public T getEntry(int givenPosition);
	public boolean contains (T anEntry);
	public T remove (int givenPosition);
	public void clear();
	public int getLength();
	public boolean isEmpty();
	public T[] toArray();

}
