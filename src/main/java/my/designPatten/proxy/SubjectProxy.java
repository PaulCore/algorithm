package my.designPatten.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * Created by paul on 2015/7/9.
 */
public class SubjectProxy {
    private Object target;

    public SubjectProxy(Object target) {
        this.target = target;
    }

    public Object  getProxy(){
        Object  proxy = null;
        proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        System.out.println(method.getName() + " before invoked with args:" + Arrays.toString(args));
                        result = method.invoke(target, args);
                        System.out.println("after invoked");
                        return result;
                    }
                });
        return proxy;
    }
}
