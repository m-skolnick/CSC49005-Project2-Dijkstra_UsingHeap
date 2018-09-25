public class Heap {

	private HeapNode _values[];
	private int _currSize;
	
	public Heap(int maxSize)
	{
		_values = new HeapNode[maxSize+1];
		_currSize = 0;
	}
	
	public boolean empty() {return _currSize==0;}
	
	public void enque(HeapNode newNode)
	{
		_currSize++;
		_values[_currSize] = newNode;
		percolateUp(_currSize);
	}
	
	private void percolateUp(int fromIndex)
	{
		if (fromIndex==1) // if root, we are done.  
			return;
		
		int parentIndex = fromIndex/2;
		
		// if out of order wrt parent 
		if (_values[parentIndex].getValue() > 
			_values[fromIndex ].getValue() )
		{
			swap(parentIndex, fromIndex);
			percolateUp(parentIndex);
		}
	}
	
	private void swap(int index1, int index2)
	{
		HeapNode temp = _values[index1];
		_values[index1] = _values[index2];
		_values[index2] = temp;
	}
	
	public HeapNode deque()
	{
		HeapNode result = _values[1];
		
		
		_values[1] = _values[_currSize];
		_values[_currSize] = null;
		_currSize--;
		
		percolateDown(1);
		
		return result;
	}
	
	private void percolateDown(int fromIndex)
	{
		int leftChildIndex = 2*fromIndex;
		int rightChildIndex = 2*fromIndex+1;
		
		if (leftChildIndex> _currSize) // no children ...
			return;
		else if (rightChildIndex > _currSize)
		{
			// look at left child, and percolate down if needed
			if (_values[fromIndex].getValue() > 
				_values[leftChildIndex].getValue() )
			{
				swap(fromIndex, leftChildIndex);
				percolateDown(leftChildIndex); // not needed
			}
		}
		else // i have two children ...
		{
			int minChildIndex = leftChildIndex;
			if (_values[rightChildIndex].getValue() < 
				_values[leftChildIndex].getValue() )
				minChildIndex = rightChildIndex;
			
			swap(minChildIndex, fromIndex);
			percolateDown(minChildIndex);
		}
	}
	
	public void changeValue(int toNewVal)
	{
		
	}
	
}