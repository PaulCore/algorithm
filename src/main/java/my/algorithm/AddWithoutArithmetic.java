package my.algorithm;

/**
 * Created by paul on 2015/7/13.
 */
public class AddWithoutArithmetic {
    public static int add(int a ,int b){
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a&b) << 1;
        return add(sum,carry);
    }

    public static int addWithLoop(int a, int b){
        int sum, carry;
        while (b!=0){
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args){
        System.out.println(add(3,5));
        System.out.println(addWithLoop(10,5));
    }

}
