import java.util.*;


public class Task9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Введите неправильное имя: ");
		String title = input.nextLine();
		System.out.printf("Правильное имя: %s\n", correctTitle(title));
	}


	public static String correctTitle(String title) {
		String[] words = title.split(" ");
		String[] constWords = new String[] {"in", "at", "of", "and"};
		String word;
		String result = "";
		FIRST:
		for (int i = 0; i < words.length; i++) {
			word = words[i];
			for (String constWord: constWords) {
				if (constWord.equals(word.toLowerCase())) {
					result += constWord + " ";
					continue FIRST;
				}
			}
			result += String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase() + " ";
		}
		return result.trim();
	}
}