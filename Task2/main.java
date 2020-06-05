import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public main(){
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("1) Введите строку и кол-во повторений букв: ");
        String aWord=sc.nextLine();
        int am=sc.nextInt();
        System.out.println(repeat(aWord,am));
        System.out.println("2) Введите кол-во элементов массива: ");
        int el= sc.nextInt();
        int[] pArr =new int[el];
        for (int i = 0; i < el; i++) {
            pArr[i] = sc.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(pArr[i]);
        }
        System.out.println("Разиница между max и min: " +difMM(pArr));
        System.out.println("3) Введите кол-во элементов массива: ");
        el= sc.nextInt();
        int[] ppArr =new int[el];
        for (int i = 0; i < el; i++) {
            ppArr[i] = sc.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(ppArr[i]);
        }
        System.out.println("Целое ли число среднее значение массива: " +isAvgW(ppArr));
        System.out.println("4) Введите кол-во элементов массива: ");
        el=sc.nextInt();

        int[] pppArr =new int[el];
        for (int i = 0; i < el; i++) {
            pppArr[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(pppArr[i]);
        }
        int[] fArr=cumArr(pppArr);
        System.out.println("Полученный массив: ");
        for (int i = 0; i < fArr.length; i++) {
            System.out.println(fArr[i]);
        }
        System.out.println("5) Введите десятичное число (разделитель - точка): ");
        String sNum=sc.nextLine();
        System.out.println("Кол-во десятичых знаков в числе: " +getDecimal(sNum));
        System.out.println("6) Введите номер числа Фибоначчи: ");
        int fibN =sc.nextInt();
        sc.nextLine();
        System.out.println("Число Фибоначчи: " +Fibo(fibN));
        System.out.println("7) Введите индекс: ");
        String ind=sc.nextLine();
        System.out.println("Реальный ли индекс: " +isRealIndex(ind));
        System.out.println("8) Введите две строки: ");
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println("Странная ли пара: " +isStrange(str1,str2));
        System.out.println("9.1) Введите слово и префикс с тире на конце: ");
        String word=sc.nextLine();
        String prefix=sc.nextLine();
        System.out.println("Является ли префиксный аргумент префиксом: " +isPrefix(word,prefix));
        System.out.println("9.2)Введите слово и префикс с тире на конце: ");
        String word1=sc.nextLine();
        String suffix=sc.nextLine();
        System.out.println("Является ли суффиксный аргумент суффиксом: " +isSuffix(word1,suffix));
        System.out.println("10) Введите шаг поледовательности: ");
        int step= sc.nextInt();
        System.out.println("Кол-во полей на данном шаге: " +boxSeq(step));
    }
    // 1)
    /* Представляем введённую строку как массив char затем прибавляем к пустой строке все символы введённой
     заданное кол-во раз */
    public static String repeat(String word, int am){
        char[] pWord = word.toCharArray();
        String gWord="";
        for (char c : pWord) {
            for (int j = 0; j < am; j++) {
                gWord += c;
            }
        }
        return gWord;
    }
    // 2)
    /* На длине всего массива сравниваем элементы с другими элементами чтобы узнать наибольший и наименьший
     затем вычитайем из max min чтобы узнать разницу */
    public static int difMM(int[] nArr){
        int max=-99999;
        int min=99999;
        for (int value : nArr) {
            if (min > value)
                min = value;
            if (max < value)
                max = value;
        }
        return max-min;
    }
    // 3)
    /* Собираем сумму всех элементов в одну переменную, затем делим сумму на кол-во элеметов и узнем ср. арифм.
     затем проверяем делится ли это число не 1 без остатка, чтобы узнать целое ли оно */
    public static boolean isAvgW(int[] nArr){
        double sum=0;
        for (int value : nArr) {
            sum += value;
        }
        return sum/nArr.length%1==0;
    }
    // 4)
    /* Цикл i добавляет в новый массив, в который будут помещены нужные значения, результаты суммирования
     в цикле j всех элементов введённого массива с j-ого элемента по нулевой */
    public static int[] cumArr(int[] pArr){
        int[] fArr=new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            for (int j = i; j >= 0; j--) {
                fArr[i]+=pArr[j];
            }
        }
        return fArr;
    }
    // 5)
    /* Разделяем строку с числом по точке и получаем массив с двумя элементами: целой частью и десятичной,
     затем переводим второй элемент массива в символьный массив и возвращаем его длину */
    public static int getDecimal(String num){
        String[] snum= num.split("\\.");
        return snum[1].toCharArray().length;
    }
    // 6)
    /* i-ый элемент последовательности Фибоначчи равне сумме двух предыдущих,
    * запишем первые 2 элемента, на основе которых будут считаться следующие */
    public static int Fibo(int n){
        int[] Fib=new int[n];
        Fib[0]=1;
        Fib[1]=2;
        for (int i = 2; i < n; i++) {
            Fib[i]=Fib[i-1]+Fib[i-2];
        }
        return Fib[n-1];
    }// 7)
    /* Запишем длину массива с индексом в переменную len, а с помощью функции matches проверяем чтобы все символы
    * строке были цифрами (отсутствие пробела так же учитывается). Затем проверяем чтобы эти 2 условия выполнялись */
    public static boolean isRealIndex(String ind){
        int len=ind.length();
        boolean dig=ind.matches("[\\d]+");
        return (len==5 && dig);
    }
    // 8)
    /* Представляем слова в виде символьных массивов и проверяем чтобы первый элемент первого массива был равен
    * последнему элементу второго массива и наоборот, и с учётом примера из задания добавим исключение, если обе строки
    * пустые возвращаться будет true */
    public static boolean isStrange(String str1, String str2){
        if (str1.isEmpty() && str2.isEmpty())
            return true;
        return str1.toCharArray()[0]==str2.toCharArray()[str2.toCharArray().length-1]
                && str1.toCharArray()[str1.toCharArray().length-1]==str2.toCharArray()[0];

    }
    // 9)
    /* Формируем из введённых слов массивы из символов и проверяем чтобы первый символ слова соответствовал\
     первому символу префикса и т.д. и так пока не исчерпается вся длина префикса, c помощью counter
     проверяем все ли символы префикса совпали с символами слова так же есть проверка на наличие
     тире в конце префикса. */
    public static boolean isPrefix(String word, String prefix){
        boolean rez=false;
        int counter=0;
        char[] cPref=prefix.toCharArray();
        int len=cPref.length;
        char[] cWord=word.toCharArray();
        for (int i = 0; i < len-1; i++) {
            if (cPref[i] == cWord[i])
                counter += 1;
        }
        if (counter==len-1)
                rez=true;
        return  rez && cPref[len-1]=='-';
    }
    /* Так же как и с префиксом только здесь сравниваются последний символ слова и последний символ суффикса,
     то есть от конца к началу, если все символы совпадают, а первым символом суффикса является тире, то
     возвращаемое значение - true */
    public static boolean isSuffix(String word, String suffix) {
        boolean rez = false;
        int counter = 0;
        char[] cSuff = suffix.toCharArray();
        int slen = cSuff.length;
        char[] cWord = word.toCharArray();
        int len = cWord.length;
        for (int i = len - 1; i > len - cSuff.length-1; i--) {
            if (cSuff[slen-1] == cWord[i])
                counter += 1;
            slen -= 1;
        }
        if (counter == cSuff.length-1)
            rez = true;
        return rez && cSuff[0] == '-';
    }
    // 10)
    /* Экспериментальным путём видно, что действие 1 выполняется, когда номер шага нечетный, и действие 2, когда номер
     шага чётный создадим цикл с проверкой таких условий и запишем сумму действий в переменную, которая будет возвращена */
    public static int boxSeq(int step){
        int rez=0;
        for (int i = 0; i < step; i++) {
            if ((i+1)%2!=0)
                rez+=3;
            else rez-=1;
        }
        return rez;
    }

}