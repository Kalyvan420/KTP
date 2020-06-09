import java.util.*;


public class Task1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Шифровать\n2. Расшифровать");
		String inputFunction = input.nextLine();
		if (inputFunction.equals("1")) {
			System.out.printf("Строка для шифровки: ");
			String string = input.nextLine();
			int[] result = encrypt(string);
			for (int i: result) {
				System.out.println(i);
			}
		}
		if (inputFunction.equals("2")) {
			System.out.printf("Строка для расшифровки: ");
			String string = input.nextLine();
			String[] stringArray = string.split(" ");
			String result = decrypt(stringArray);
			System.out.println(result); 
		}
	}


	public static int[] encrypt(String string) {
		int[] result = new int[string.length()];
		int last = 0;
		int i = 0;
		for (char c: string.toCharArray()) {
			result[i] = (int)c - last;
			last = (int)c;
			i++;
		}
		return result;
	}


	public static String decrypt(String[] string) {
		String result = "";
		int last = 0;
		for (String i: string) {
			result += String.valueOf((char)(Integer.parseInt(i) + last));
			last += Integer.parseInt(i);
		}
		return result;
	}
}