import java.util.Scanner;


public class HackerRanks {
	/*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum);
        sc.close();
    }*/
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int first_sum = 0;
        int second_sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int elem = sc.nextInt();
                if (i == j) {
                    first_sum += elem;
                }
                if (i + j == size - 1) {
                    second_sum += elem;
                }
            }
        }
        System.out.println(Math.abs(first_sum - second_sum));
        sc.close();
    }
}
