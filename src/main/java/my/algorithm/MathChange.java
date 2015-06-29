package my.algorithm;

import java.util.Stack;

/**
 * Created by paul on 2015/6/29.
 * 10进制数转换为M进制
 */
public class MathChange {
    /**
     *
     * @param num
     * num为需要转化的原数
     * @param m
     * m为需要转化的进制
     * @param n
     * n为原进制
     * @return
     */
    public static String tansform(int num, int m, int n){
        Stack<Integer> stack = new Stack<Integer>();
       //先将n进制的书num转为10进制,利用辗转相除法，t为余数，商为0时，保存余数，结束
       //利用栈保存余数，出栈顺序即为最后结果
        String s = String.valueOf(num);
        int re = 0;
        for (int i = 0; i < s.length(); i++){
            re = re*n + (s.charAt(i) - 48);
        }
        System.out.println(n + "进制数转换为" +num  + "转换为10进制的结果为：" + re);
        int t = re/m;
        while (t != 0){
            stack.push(re%m);
            re = t;
            t = re/m;
        }
        stack.push(re%m);
        System.out.println(stack);
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            int res = stack.pop();
            sb.append(res);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       String s = tansform(11,4,8);
        System.out.println(s);
    }
}
