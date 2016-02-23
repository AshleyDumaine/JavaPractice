
public class Window {
	private int x, y, w, h;
	public Window() {
		x = 0;
		y = 0;
		w = 0;
		h = 0;
	}
	public Window(String input) {
		input = input.replaceAll("[^-?0-9]+", " "); 
		String[] parameters = input.trim().split(" ");
		x = Integer.parseInt(parameters[0]);
		y = Integer.parseInt(parameters[1]);
		w = Integer.parseInt(parameters[2]);
		h = Integer.parseInt(parameters[3]);
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public int w() {
		return w;
	}
	
	public int h() {
		return h;
	}
}
