import java.util.*;


public class Task5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Масса: ");
		String m = input.nextLine();
		System.out.printf("Высота: ");
		String h = input.nextLine();
		System.out.println(BMI(m, h));
	}


	public static String BMI(String m, String h) {
		double mass = 0;
		double height = 0;
		Map<String, Double> metrics = new HashMap<String, Double>();
		metrics.put("Фунты", 2.205);
		metrics.put("Килограммы", 1.0);
		metrics.put("Дюймы", 39.37);
		metrics.put("Метры", 1.0);
		for (Map.Entry<String,Double> entry: metrics.entrySet()) {
			if (m.indexOf(entry.getKey()) != -1) {
				mass = Double.parseDouble(m.replace(entry.getKey(), "").trim()) / entry.getValue();
			}
			if (h.indexOf(entry.getKey()) != -1) {
				height = Double.parseDouble(h.replace(entry.getKey(), "").trim()) / entry.getValue();
			}
		}
		double res = mass / Math.pow(height, 2);
		if (res < 18.5) return String.format("%.1f", res) + " Недовес";
		else if (res >= 18.5 && res < 24.9) return String.format("%.1f", res) + " Нормальный вес";
		return String.format("%.1f", res) + " Перевес";
	}
}