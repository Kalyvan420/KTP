import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("1) Введите коэф. квадратного уравнения: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        System.out.println("Количество корней уравенеия: " +qEq(a,b,c));
        System.out.println("2) Введите строку: ");
        String zipW = sc.nextLine();
        System.out.println("Позиция второго zip: " +findZip(zipW));
        System.out.println("3) Введите число: ");
        int pNum = sc.nextInt();
        sc.nextLine();
        System.out.println("Совершенное ли число: " +checkPerf(pNum));
        System.out.println("4) Введите строку: ");
        String word=sc.nextLine();
        System.out.println("Результат: " +exStr(word));
        System.out.println("5) Введите строку: ");
        String wordH=sc.nextLine();
        System.out.println("Результат: " +isHex(wordH));
        int[] pArr1=new int[]{1,2,3};
        int[] pArr2=new int[]{5,2,3};
        System.out.println("6) Массивы для проверки: ");
        System.out.println(pArr1[0]+" "+pArr1[1]+" "+pArr1[2]);
        System.out.println(pArr2[0]+" "+pArr2[1]+" "+pArr2[2]);
        System.out.println("Одинаковое ли кол-во уникальных элементов: " +isSame(pArr1,pArr2));
        pArr1=new int[]{1,2,3};
        pArr2=new int[]{2,3,3};
        System.out.println(pArr1[0]+" "+pArr1[1]+" "+pArr1[2]);
        System.out.println(pArr2[0]+" "+pArr2[1]+" "+pArr2[2]);
        System.out.println("Одинаковое ли кол-во уникальных элементов: " +isSame(pArr1,pArr2));
        System.out.println("7) Введите целое положительное число: ");
        int kap = sc.nextInt();
        sc.nextLine();
        System.out.println("Является ли число числом Капрекара: " +isKap(kap));

        System.out.println("8) Введите строку двоичного кода: ");
        String bS=sc.nextLine();
        System.out.println("Самая длинная последовательность нулей в строке: " +longestZero(bS));
        System.out.println("9) Введите число для проверки след. простого числа: ");
        int pI=sc.nextInt();
        System.out.println("Результат: " +nextPrime(pI));
        System.out.println("10) Введите стороны треугольника: ");
        int aT=sc.nextInt();
        int bT=sc.nextInt();
        int cT=sc.nextInt();
        System.out.println("Прямоугольный ли треугольник: " +isRight(aT,bT,cT));

    }
    //1)
    /* 1) Считаем дискриминант, если D=0 корень 1, если D>0, корня 2, иначе корней нет*/
    public static int qEq(int a, int b, int c){
        double disc=b*b-4*a*c;
        if (disc>0)
            return 2;
        if (disc==0)
            return 1;
        return 0;
    }
    //
    /* 2) Проверяем строку на три последовательных символа z, i и p */
    public static int findZip(String zip){
        int mem=0;
        int check=0;
        char[] zipA=zip.toCharArray();
        for (int i = 2; i < zipA.length ; i++) {
            if (zipA[i-2]=='z' && zipA[i-1]=='i' && zipA[i]=='p'){
                check += 1;
                if (check==2)
                    mem=i-2;
            }
        }
        return mem;
    }
    //
    /* 3) Суммируем все множетели числа и сравниваем с введённым */
    public static boolean checkPerf(int n){
        int sum=0;
        for (int i = 1; i < n; i++) {
            if (n%i==0)
                sum+=i;
        }
        return sum==n;
    }
    //
    /* 4) Сначала проверка на длину строки и соответсв. вывод, затем проверка на первый и
    * последний символ и соответств. вывод, затем замена букв в строке с помощью перевода её в символьный массив */
    public static String exStr(String word){
        if (word.length()<2)
            return "incompatible";
        if (word.toCharArray()[0]==word.toCharArray()[word.toCharArray().length-1])
            return "Two's a pair";
        char[] mWord = word.toCharArray();
        char pHolder=mWord[mWord.length-1];
        mWord[mWord.length-1]=mWord[0];
        mWord[0]=pHolder;
        String rez= new String(mWord);
        return rez;
    }
//    /* 5) Добавляем условия в переменные булевого типа. Сначала смотрим чтобы строка начиналась с #,
//    затем смотрим чтобы длина была 7 (6 без решётки), затем проверяем чтобы все символы начиная со 2-ого
//    соответствовали условиям, если один элемент не подходит проверка прекращается*/
    public static boolean isHex(String hexC) {
        boolean c1 = hexC.toCharArray()[0] == '#';
        boolean c2 = hexC.length() == 7;
        boolean c3 = true;
        char[] hexA = hexC.toCharArray();
        for (char i = 1; i < hexA.length - 1; i++) {
            c3 = ((hexA[i] >= 'a') && (hexA[i] <= 'f')) ||
                    ((hexA[i] >= 'A') && (hexA[i] <= 'F')) ||
                    ((hexA[i] >= '0') && (hexA[i] <= '9'));
            if (!c3) {
                break;
            }
        }
        return c1 && c2 && c3;
    }
//    /* 6) Сначала сортируем массивы, затем с помощью циклов проверяем количество уникальных элементов массива
//    в обоих массивах, в конце возвращаем результат сравнения */
    public  static boolean isSame(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr1.length; i++)
        {
            while (i < arr1.length - 1 && arr1[i] == arr1[i + 1])
                i++;
            res1++;
        }
        for (int i = 0; i < arr2.length; i++)
        {
            while (i < arr2.length - 1 && arr2[i] == arr2[i + 1])
                i++;
            res2++;
        }
        return res1==res2;
        }
//    /* 7) Сначала находим квадрат введенного числа, затем находим длину числа в квадрате, потом присваиваем
//    правому слагаемому значение начиная с середины слова. Потом если число имеет длину 1, то левому слагаемому
//    присваивается 0, иначе ему присваевается число до находяещееся до середины квадрата введённого,
//    потом проходит проверка равенства введенного числа и суммы левого и правого слагаемого */
    public static boolean isKap(int num){
        int left,right = 0;
        int sq= (int) Math.pow(num,2);
        String num1 = String.valueOf(sq);
        int mid = num1.length()/2;
        right=Integer.parseInt(num1.substring(mid));
        if (num1.length()==1)
            left=0;
        else
            left=Integer.parseInt(num1.substring(0,mid));
        return left+right==num;
        }
    /* 8) Представляем строке единиц и нулей в форме стркового массива, и проверяем его на количество подряд идущих
    * нулей, когда последовательность кончается длинна записывается в отдельную переменную в случае, если длина
    * настояещей последовательности больше уже записанной, в конце выводим строку 0 повторяющийся найденное кол-во раз */
    public static String longestZero(String seq){
        int mI=0;int cI=0;int mL=0;int cL=0;
        char[] seqA=seq.toCharArray();
        for (int i = 0; i < seqA.length; i++) {
            if (seqA[i] == '0') {
                cL += 1;
                if (cL == 1)
                    cI = i;
            } else {
                if (cL > mL) {
                    mL = cL;
                    mI = cI;
                }
                cL = 0;
            }
        }
        String rez="0";
        System.out.println("Длинна последовательности: " +mL);
        return rez.repeat(mL);
        }
    /* 9) Проверяем все числа с введенного на их делители, если есть делители кроме 1 и себя то введённое число
    * увеличивается на 1 и т.д. */
    public static int nextPrime(int num){
        while(true){
            int l = (int) Math.sqrt(num);
            int counter = 0;
            for(int i = 2; i <= l; i ++){
                if(num % i == 0)
                    counter++;
            }
            if(counter == 0)
                return num;
            else{
                num++;
            }
        }
    }
    /* 10) Проверка сторон на удоволетворение теоремы Пифагора */
    public static boolean isRight(int a, int b, int c){
        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }
}
