package my.boring;

import java.awt.*;

/**
 * Created by paul on 2015/7/6.
 */
public enum EnumDemo {
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,255);
    private EnumDemo(int rd, int gv, int bv){
        redValue = rd;
        greenValue = gv;
        blueValue = bv;
    }

    @Override
    public String toString() {
        return super.toString() + "(" +  redValue + "," + greenValue +"," + blueValue + ")";
    }

    private int redValue;
    private int greenValue;
    private int blueValue;

    public static void main(String[] args) {
//        EnumDemo ed = EnumDemo.BLUE;
//        System.out.println(ed);

//        EnumDemo[] eds = EnumDemo.values();
//        for (EnumDemo ed: eds){
//            System.out.println(ed);
//        }

       EnumDemo ed =  EnumDemo.valueOf("BLUE");
        System.out.println(ed);

        System.out.println(ed.ordinal());
    }
}
