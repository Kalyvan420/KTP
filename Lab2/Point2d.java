public class Point2d {
    private double xCoord;
    private double yCoord;
    public Point2d (double x, double y){
        xCoord = x;
        yCoord = y;
    }
    /** Конструктор по умолчанию **/
    public Point2d(){
        //Вызовите конструктор с двумя параметрами и определите источник.
        this (0,0);
    }
    public double getX2(){// Возвр коорд X
        return xCoord;
    }
    public double getY2(){// Возвр коорд y
        return yCoord;
    }
    /** Установка значения координаты X и Y**/
    public void setX2(double val){
        xCoord = val;
    }
    public void setY2(double val) {
        yCoord = val;
    }
    public static boolean Check2D(Point2d first, Point2d two){
        if ((first.getX2() == two.getX2()) && (first.getY2() == two.getY2()))
        {
            return true;
        }
        else
            {
            return false;
            }
    }
}