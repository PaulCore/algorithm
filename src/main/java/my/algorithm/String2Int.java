package my.algorithm;

/**
 * Created by paul on 2015/6/18.
 */
public class String2Int {
    public static void main(String[] args) throws Exception {
//        int data = string2Int("+40s");
        int data = string2Int("-40");
        System.out.println(data);
    }

    public static int string2Int(String s) throws Exception{
        if (s==null||s==""){
            throw new  Exception("输入不能为空");
        }
        int result = 0;
        int sig = 1;
        char c = s.charAt(0);
        int i = 0;//记录当前位置


        int length = s.length();
        //判断第一位是否存在符号
        if (c < '0'){
            if (c=='-')
                sig = -1;
            else if (c!='+'){
                throw new  Exception("格式有问题");
            }
            if (length==1)
                throw new  Exception("格式有问题");
            i++;
        }
        while (i < length){
            c = s.charAt(i);
            result = result*10 + char2Int(c);
            i++;
        }

        return result * sig;
    }

    public static int char2Int(char c) throws Exception {
        if (c<48||c>57){
            throw  new Exception("格式有问题");
        }
        return c-48;
    }
}
