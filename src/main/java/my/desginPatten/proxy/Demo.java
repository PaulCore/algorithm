package my.desginPatten.proxy;

/**
 * Created by paul on 2015/7/9.
 */
public class Demo {
    public static void main(String[] args){

        RealSubject realSubject = new RealSubject();
        SubjectProxy proxy = new SubjectProxy(realSubject);
        Subject subject = (Subject) proxy.getProxy();
        int result = subject.add(1,2);
        System.out.println(result);
    }
}
