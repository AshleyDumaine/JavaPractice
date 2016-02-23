//implement a queue with 2 stacks
import java.util.Stack;

public class StackQueue {
	private Stack<Object> tempQueue;
	private Stack<Object> mainQueue;
	public StackQueue() {
		this.tempQueue = new Stack<Object>();
		this.mainQueue = new Stack<Object>();
	}
	public void enqueue(Object object) {
		this.mainQueue.push(object);
	}
	public Object dequeue() {
		while (!this.mainQueue.isEmpty()) { //reverse order of elements by moving everything onto temp stack
			Object current = this.mainQueue.pop();
			this.tempQueue.push(current);
		}
		Object res = this.tempQueue.pop(); //get first element entered
		while (!this.tempQueue.isEmpty()) { //restore the main queue
			Object current = this.tempQueue.pop();
			this.mainQueue.push(current);
		}
		return res;
	}
	public boolean isEmpty() {
		return this.mainQueue.size() == 0 ? true : false;
	}

	public static void main(String[] args) {
		StackQueue sq = new StackQueue();
		sq.enqueue(1);
		sq.enqueue(2);
		sq.enqueue(3);
		sq.enqueue(4);
		sq.enqueue(5);
		while (!sq.isEmpty()) {
			Integer res = (Integer) sq.dequeue();
			System.out.println(res);
		}
	}	
}
