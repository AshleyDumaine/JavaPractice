//Ashley Dumaine
//CSE2100-001
//Fall 2013
//Lab 02
//September 15, 2013

public class DoublyLinkedList 
{
	protected Node _tail;
	protected Node _head;
	protected int _size;
	//sets up blank list of 0 length
	public DoublyLinkedList()
	{
		_tail = null;
		_head = null;
		_size = 0;
	}
	//lets user know list length
	public int getSize()
	{
		return _size;
	}
	//checks to see if the linked list is empty
	public boolean isEmpty()
	{
		return _size == 0;
	}
	//returns the head of the linked list
	public Node getFirst()
	{
		return _head;
	}
	//iterates over all the nodes and concatenates them into a string
	@Override
	public String toString()
	{
		String result = "";
		Node tempNode = this._head;
		while (tempNode != null)
		{
			result = result + tempNode.data();
			tempNode = tempNode.next();
		}
		return result;
	}
	//appends node to end of list
	public void addLast(Node data)
	{
		if (_tail == null)
		{
			data.setNext(null);
			_head = _tail = data;	
		}
		else
		{
			_tail.setNext(data);
			data.setPrev(_tail);
			_tail = data;
			data.setNext(null);
		}
		_size++;
	}
	//appends node to front of list
	public void addFirst(Node data)
	{
		if (_head == null)
		{
			_head = _tail =  data;
			data.setNext(null);
			data.setPrev(null);
		}
		else
		{
			data.setNext(_head);
			_head.setPrev(data);
			_head = data;	
			data.setPrev(null);
		}
		_size++;
	}
	//deletes first node of list
	public Node removeFirst()
	{
		Node tempNode = _head;
		_head = _head.next();
		_size--;
		return tempNode;
	}
}