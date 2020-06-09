import java.util.*;


public class Task1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("N: ");
		int n = Integer.parseInt(input.nextLine());
		System.out.printf("K: ");
		int k = Integer.parseInt(input.nextLine());
		System.out.printf("Строка: ");
		String text = input.nextLine();
		System.out.println(essay(n, k, text));
	}


	public static String essay(int n, int k, String text) {
		String[] words = text.split(" ");
		String currentString = "";
		String result = "";
		boolean added = false;
		if (n > words.length) return "Не получилось создать эссе с такими параметрами";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (currentString.replace(" ", "").length() + word.length() <= k) currentString += word + " ";
			else {
				result += currentString + "\n";
				currentString = word + " ";
			}
		}
		if (currentString.length() > 0) {
			result += currentString + "\n";
		}
		return result;
	}
}