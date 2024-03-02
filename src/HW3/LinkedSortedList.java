package HW3;

public class LinkedSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
	private Node firstNode; 
	private int numberOfEntries;
	public LinkedSortedList()
	{
	firstNode = null;
	numberOfEntries = 0;
	}
	

	@Override
	public void add(T newEntry) {
		Node newNode = new Node (newEntry);
		Node nodeBefore = getNodeBefore(newEntry); 
		if (isEmpty() || (nodeBefore == null))
		{
			newNode.setNextNode(firstNode); firstNode = newNode;
		}
		
		
		else
		{
		// Add after nodeBefore
		Node nodeAfter = nodeBefore.getNextNode();
		newNode.setNextNode(nodeAfter);
		nodeBefore.setNextNode (newNode);
		} // end if
		numberOfEntries++;
		
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);
		if (position > 0)
		{
		remove(position);
		result = true;
		} // end if
		return result;
		
	}

	@Override
	public int getPosition(T anEntry) {
		 int position = 1;
		  int length = getLength();
		    // Find position of anEntry
		  while ( (position <= length) && (anEntry.compareTo(getEntry(position)) > 0) ){ 
		        position++;
		    } // end while
		    // See whether anEntry is in list
		  if ( (position > length) ||
		    (anEntry.compareTo(getEntry(position)) != 0) ){
		    position = -position; // anEntry is not in list
		    } // end if
		    return position;
		
		
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		
		else
		throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
        Node currentNode = firstNode;
        while (!found & (currentNode != null))
            if (anEntry.equals (currentNode.getData()))
                found = true;
            else {
                currentNode = currentNode.getNextNode ();
    } // end while
    return found;

		
	}

	@Override
	public T remove(int givenPosition) {
		{
			
			T result = null;
			// Return value
			if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
				assert !isEmpty();
				if (givenPosition == 1)
				{
					result = firstNode.getData();			
					firstNode = firstNode.getNextNode(); 
			}
				else{
					Node nodeBefore = getNodeAt(givenPosition - 1); 
					Node nodeToRemove = nodeBefore.getNextNode();
					result = nodeToRemove.getData();
					
					Node nodeAfter = nodeToRemove.getNextNode();
					nodeBefore.setNextNode (nodeAfter);
					} // end if 
				numberOfEntries--; 
				return result;
			
			}
			else
				throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
			
			
		}			
			
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;		
		
	}

	@Override
	public int getLength() {
		
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if (numberOfEntries== 0)
		
		{	assert firstNode == null;
			result = true;
		}
		else
		{
			assert firstNode != null;
			result = false;
		} // end if
		return result; 
		} //end isEmpty
		
	

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object [numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData(); 
			currentNode = currentNode.getNextNode();
			index++;
		} // end while
		return result;
	}
	private Node getNodeBefore(T anEntry)
	{
		Node currentNode = firstNode;
		Node nodeBefore = null;
	while((currentNode != null) &&(anEntry.compareTo(currentNode.getData()) > 0))
	{
	
		nodeBefore = currentNode;
		currentNode = currentNode.getNextNode();
	} // end while
	return nodeBefore;
	} //end getNodeBefore
	

	private Node getNodeAt(int givenPosition)
	{
		assert (firstNode != null) &&
		(1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++) 
			currentNode = currentNode.getNextNode();
		assert currentNode != null;
		return currentNode;
} //end getNodeAt
	
	
	private class Node

	{
		private T data;
					
		private Node next;
		private Node(T dataPortion)
		{
			this (dataPortion, null);
		} // end constructor
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} //end constructor
		
		

		private T getData()
		{
			return data;
		} //end getData
		private void setData(T newData)
		{
			data = newData;
		} //end setData
		private Node getNextNode()
		{
			return next;
		}
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} //end setNextNode
		
	}
	
	

}
