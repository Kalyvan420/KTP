public class Point2d {
    /**Кордината X**/
    private double xCoord;
    /**Кордината Y**/
    private double yCoord;
    /** Конструктор инициализации **/
    public Point2d (double x, double y){
        xCoord = x;
        yCoord = y;
    }
    /** Конструктор по умолчанию **/
    public Point2d(){
        //Вызовите конструктор с двумя параметрами и определите источник.
        this (0,0);
    }
    /** Возвращение координаты X **/
    public double getX2(){
        return xCoord;
    }
    /** Возвращение координаты Y **/
    public double getY2(){
        return yCoord;
    }
    /** Установка значения координаты X **/
    public void setX2(double val){
        xCoord = val;
    }
    public void setY2(double val) {
        yCoord = val;
    }
    public static boolean Check2D(Point2d first, Point2d two){
        if ((first.getX2() == two.getX2()) && (first.getY2() == two.getY2())){
            return true;
        }
        else {return false;}
    }
}