import java.util.*;


public class Task3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Входная строка: ");
		String shortword = input.nextLine();
		System.out.printf("Слово: ");
		String longword = input.nextLine();
		System.out.println(canComplete(shortword, longword));
	}


	public static boolean canComplete(String shortword, String longword) {
		boolean exists = false;
		for (char c: shortword.toCharArray()) {
			exists = false;
			for (int i = 0; i < longword.length(); i++) {
				if (c == longword.charAt(i)) {
					longword = longword.substring(i + 1);
					exists = true;
					break;
				}
			}
			if (!exists) return false;
		}
		return true;
	}
}