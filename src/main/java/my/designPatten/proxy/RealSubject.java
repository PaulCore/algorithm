package my.designPatten.proxy;

/**
 * Created by paul on 2015/7/9.
 */
public class RealSubject implements Subject {
    @Override
    public int add(int a, int b) {
        System.out.println("add invoked");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub invoked");
        return a - b;
    }
}
