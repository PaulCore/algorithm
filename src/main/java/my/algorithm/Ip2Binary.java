package my.algorithm;

import java.util.Stack;

/**
 * Created by paul on 2015/6/30.
 */
public class Ip2Binary {
    public static void main(String[] args) {
//        int i = 7;
//        System.out.println(i << 1);
//        System.out.println(i >> 1);
//        System.out.println(i & 1);
//        Stack<Integer> stack = new Stack<Integer>();
//        while (i != 0){
//            stack.push(i & 1);
//            i = i >> 1;
//        }
//        while (!stack.isEmpty()){
//            System.out.print(stack.pop());
//        }
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//
//        System.out.println(c == d);
//        System.out.println(e == f);
//        System.out.println(c == (a + b));
//        System.out.println(c.equals(a + b));
//        System.out.println(g == (a + b));
//        System.out.println(g.equals(a + b));
        toBinary("192.168.1.1");

    }

    public static Stack<Integer> toBinary(String ip){
        Stack<Integer> result = new Stack<Integer>();
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; i++){
            int2binary(Integer.valueOf(ips[i]),result);
            System.out.println("*");
        }
        return result;
    }

    public static void int2binary(int data, Stack<Integer> stack){
        Stack<Integer> temp = new Stack<Integer>();
        while (data != 0 ){
            temp.push(data & 1);//相当于data%2
            data = data >> 1;//相当于data/2
        }
        for (;temp.size() <= 8;){
            temp.push(0);
        }
        while (!temp.isEmpty())
            System.out.print(temp.pop());
    }
}
