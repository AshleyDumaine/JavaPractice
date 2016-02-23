

public class Lytmus {
	public static void main(String args[]) {
		//System.out.println(abbreviateFullName("ashley morgan dumaine"));
		String[] input = {"X=5 Y=9 W=10 H=40", "X=11 Y=79 W=10 H=40", "X=12 Y=17 W=10 H=40", "X=15 Y=9 W=10 H=40"};
		System.out.println(getEnclosingRectangle(input));
	}
	public static String abbreviateFullName(String name) {
		if (name == null) {
			return "";
		}
		String[] names = name.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.length - 1; i++) {
			sb.append(Character.toUpperCase(names[i].charAt(0))).append(". ");
		}
		String lastName = Character.toUpperCase(names[names.length - 1].charAt(0)) 
				+ names[names.length - 1].substring(1);
		sb.append(lastName);
		return sb.toString();
	}
	
	public static String getEnclosingRectangle(String windows[]) {
		if (windows == null || windows.length == 0) {
            return "";
        }
        // x for window is the smallest x of the windows
        // width is the largest (x + width) of the windows
        // y is the largest y of the windows
        // height is the largest (height - y) of the windows
        Window[] rectangles = new Window[windows.length];
        for (int i = 0; i < windows.length; i++) {
            rectangles[i] = new Window(windows[i]);
        }
        int x = Integer.MAX_VALUE; // smallest x
        int y = Integer.MIN_VALUE; // largest y
        int small_y = Integer.MAX_VALUE; // unit test is not using a regular x-y coordinate grid and wants smallest y
        int w = Integer.MIN_VALUE; // largest x + width
        int h = Integer.MAX_VALUE; // smallest y - height
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].x() < x) {
                x = rectangles[i].x();
            }
            if (rectangles[i].y() < small_y) {
                small_y = rectangles[i].y();
            }
            if (rectangles[i].y() > y) {
                y = rectangles[i].y();
            }
            if (rectangles[i].x() + rectangles[i].w() > w) {
                w = rectangles[i].x() + rectangles[i].w();
            }
            if (rectangles[i].y() - rectangles[i].h() < h) {
                h = rectangles[i].y() - rectangles[i].h();
            }
        }
        w = w - x; // to account for the leftmost window's x being nonzero
        h = y - h; // to account for the topmost window's y being nonzero
        StringBuilder sb = new StringBuilder();
        sb.append("X=").append(x).append(" Y=").append(small_y).append(" W=").append(w).append(" H=").append(h);
        return sb.toString();
	}
}
