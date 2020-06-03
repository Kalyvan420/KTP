import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        double x,y,z;
        DecimalFormat df = new DecimalFormat("###.##");
        /**Ввод данных с консоли **/
        Scanner in = new Scanner(System.in);
        /** Ввод первой точки **/
        System.out.println("Введите координаты первой точки");
        System.out.println("Введите  X");
        x=in.nextDouble();
        System.out.println("Введите  Y");
        y=in.nextDouble();
        System.out.println("Введите  Z");
        z=in.nextDouble();
        Point3d onepoint = new Point3d(x, y, z);//создание первой точки

        /** Ввод второй точки **/
        System.out.println("Введите координаты второй точки");
        System.out.println("Введите  X");
        x=in.nextDouble();
        System.out.println("Введите  Y");
        y=in.nextDouble();
        System.out.println("Введите  Z");
        z=in.nextDouble();
        Point3d twopoint = new Point3d(x, y, z);//создание второй точки

        /** Ввод третьей точки **/
        System.out.println("Введите координаты третьей точки");
        System.out.println("Введите  X");
        x=in.nextDouble();
        System.out.println("Введите  Y");
        y=in.nextDouble();
        System.out.println("Введите  Z");
        z=in.nextDouble();
        Point3d threepoint = new Point3d(x, y, z);//создание третьей точки

        /** Проверка точек на равенство **/
        if ((Point3d.Check3D(onepoint,twopoint) == false)
                &&(Point3d.Check3D(onepoint,threepoint) == false)
                &&(Point3d.Check3D(twopoint,threepoint) == false))
        {System.out.println("Точки не равны, продолжение выполнения");}
        else {System.out.println("Точки имеют одинаковые координаты, конец программы"); System.exit(0);}

        /**площадь треугольника **/
        double P = Point3d.computeArea(onepoint,twopoint,threepoint);
        System.out.println("Площадь треугольника равна = " + df.format(P));

    }
}