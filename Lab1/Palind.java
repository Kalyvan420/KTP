import java.util.Scanner;

public class Palind {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//описываем класс сканер, чтобы считывать введённую информацию
        System.out.println("Введите строку");
        String str = in.nextLine();//считываем введённую строку
        String rstr = reverseStr(str);//заносим полученную строку в функцию реверсирования строки
        System.out.println("Введенная строка: " + str);
        System.out.println("Строка наоборот: " + rstr);
        //если функция проверки возвращает true, выводим, что введённая строка палиндромом
        if (isPalind(str, rstr) == true){System.out.println(str+ " - палиндромом");}
        else {System.out.println(str + " - не палиндромом");}
    }

    public static String reverseStr(String instr){
        String outstr = "";
        for (int i =instr.length()-1; i>=0; i=i-1)//цикл создания реверсивной строки
        {outstr += instr.charAt(i);}
        return outstr;

    }

    public static boolean isPalind(String firststr, String newstr){
        if (firststr.equals(newstr) == true)
        {
            return true;
        }
        else
            {
            return false;
            }

    }
}