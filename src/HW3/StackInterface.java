package HW3;

public interface StackInterface<T extends Comparable<? super T>> {

	public T peek();
	public T pop();
	public void push(T newEntry);
	public boolean isEmpty();
	public void clear();

}
