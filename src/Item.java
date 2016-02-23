public class Item implements Comparable<Item>{
	private int index;
	private int price;
	public Item() {
	}
	public Item(int price, int index) {
		this.price = price;
		this.index = index;
	}
	public int index() {
		return this.index;
	}
	public int price() {	
		return this.price;
	}

	@Override
	public int compareTo(Item item)
	{
	    if(this.price == item.price())
	        return 0;
	    else if (this.price < item.price())
	        return -1;
	    else 
	        return 1;
	}
}
