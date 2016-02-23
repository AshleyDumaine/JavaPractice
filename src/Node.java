//Ashley Dumaine
//CSE2100-001
//Fall 2013
//Lab 01
//September 12, 2013
public class Node 
{
	private Object _data;
	private Node _next;
	private Node _prev;
	private Node left;
	private Node right;
	
	public Node()
	{
		this(null, null, null);
	}
	public Node(Object element)
	{
		_data = element;
	}
	public Node(Object element, Node next)
	{
		_data = element;
		_next = next;
	}
	public Node(Object element, Node next, Node prev) {
		_data = element;
		_next = next;
		_prev = prev;
	}
	public void setPrev(Node prev) 
	{
		this._prev = prev;
	}
	public void setLeft(Node left) 
	{
		this.left = left;
	}
	public void setRight(Node right)
	{
		this.right = right;
	}
	public Node next()
	{
		return _next;
	}
	public Node prev()
	{
		return _prev;
	}
	public Object data()
	{
		return _data;
	}
	public void setNext(Node newNext)
	{
		_next = newNext;
	}
	public void setData(Object element)
	{
		_data = element;
	}
	public Node left()
	{
		return this.left;
	}
	public Node right()
	{
		return this.right;
	}
}
