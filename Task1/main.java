import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        /* 1) */
        System.out.println("1) ");
        System.out.println(3%4);
        System.out.println(5%5);
        /* 2) */
        System.out.println("2) Введите основание и высоту треуг.: ");
        double a=sc.nextDouble();
        double h=sc.nextDouble();
        System.out.println("Площадь треуг.:" +triArea(a,h));
        /* 3) */
        System.out.println("3) Введите кол-во куриц, коров и свиней: ");
        int chick=sc.nextInt();
        int cows=sc.nextInt();
        int pigs=sc.nextInt();
        System.out.println("Общее кол-во ног скота: " +legs(chick,cows,pigs));
        /* 4) */
        System.out.println("4) Введите вер. выигрыша, размер выигрыша, ставку: ");
        double prob=sc.nextDouble();
        double prize=sc.nextDouble();
        double pay=sc.nextDouble();
        System.out.println(gamb(prob,prize,pay));
        /* 5) */
        System.out.println("5) Введите три числа: ");
        int ch1=sc.nextInt();
        int ch2=sc.nextInt();
        int ch3=sc.nextInt();
        System.out.println("Дествие: ");
        act(ch1,ch2,ch3);
        /* 6) */
        System.out.println("6) Введите символ: ");
        char aC=sc.next().charAt(0);
        System.out.println("ASCII код символа: " +aCode(aC));
        /* 7) */
        System.out.println("7) Введите число:");
        int cA= sc.nextInt();
        System.out.println("Сумма всех цифр до введеного числа: " +addUp(cA));
        /* 8) */
        System.out.println("8) Введите значения двух ребёр треугольника: ");
        int r1=sc.nextInt();
        int r2=sc.nextInt();
        System.out.println("Максимальное значения третьего ребра треугольника: "+ lEdge(r1,r2));
        /* 9) */
        System.out.println("9) Введите кол-во элементов массива: ");
        int el=sc.nextInt();
        int pArr[]=new int[el];
        for (int i = 0; i < el; i++) {
            pArr[i]=sc.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < el; i++) {
            System.out.println(pArr[i]);
        }

        System.out.println("Сумма кубов введенных элементов: " +cArr(pArr));
        /* 10) */
        System.out.println("10) Введите a, b, c");
        int aM=sc.nextInt();
        int bM=sc.nextInt();
        int cM=sc.nextInt();
        System.out.println("Результат: " +abcMath(aM,bM,cM));

    }
    // Функции
    // 2)
    public static double triArea(double a, double h){
        return (0.5 * a * h);//Площаль треугольника равна S=1/2*a*h
    }
    // 3)
    public static int legs(int chick, int cows, int pigs){
        return chick*2+cows*4+pigs*4;//Умножаем введенных животных на кол-во их ног и суммируем
    }
    // 4)
    public static boolean gamb(double prob, double prize, double pay){
        return prob*prize>pay;//Если условие выполняется будет возвращё true, иначе false
    }
    // 5)
    public static void act(int a, int b, int N){
        if (a+b==N)//Проверка каждого условия и вывод соответс. сообщения
            System.out.println("add");
        else if (Math.abs(a-b)==N)
            System.out.println("subtract");
        else if (a*b==N)
            System.out.println("multiply");
        else if (a/b==N || b/a==N)
            System.out.println("divide");
        else
            System.out.println("none");
    }
    // 6)
    public static int aCode(char ch){
        return ch;//Значением int переменной типа char является его ASCII код
    }
    // 7)
    public static int addUp(int a){
        int z=0;
        for (int i = a; i > 0; i--) {//Сложение всех чисел меньше введеного включительно до 0
            z+=i;
        }
        return z;
    }
    // 8)
    public static int lEdge(int a, int b){
        return a+b-1;//Ребра треугольника a,b,c должны должны выполнять условие a+b>c(и так для всех)-> c=a+b-1, т.к int
    }
    // 9)
    public static int cArr(int pArr[]){
        int sum=0;
        for (int i = 0; i < pArr.length; i++) {//Прибавление всех эл. массива. к сумме предварит. возведя в куб
            sum+=Math.pow(pArr[i],3);
        }
        return sum;
    }
    // 10)
    /* При прибавлении числа к себе по правилу из задания, можно заметить, что
    сумма относится к переменной a, как sum/a=2^b, -> sum=a*2^b */
    public static boolean abcMath(int a, int b, int c){
        return a*Math.pow(2,b)%c==0;
    }

}

