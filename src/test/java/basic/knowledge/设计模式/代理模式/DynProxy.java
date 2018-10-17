package basic.knowledge.设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: CarryJey @Date: 2018/10/17 22:46:45
 * desc: 动态代理模式
 */
/**
 * 设计模式是语言的表达方式，它能让语言轻便而富有内涵、易读却功能强大。
 * 代理模式在Java中十分常见，有为扩展某些类的功能而使用静态代理，也有如Spring实现AOP而使用动态代理，更有RPC实现中使用的调用端调用的代理服务。
 * 代理模型除了是一种设计模式之外，它更是一种思维，所以探讨并深入理解这种模型是非常有必要的。
 */

/**
 * Jdk的动态代理，是使用反射技术获得类的加载器并且创建实例，根据类执行的方法在执行方法的前后发送通知。
 * 接口和实现类还是使用上面贴出来的。
 * 在代理对象Proxy的新建代理实例方法中，必须要获得类的加载器、类所实现的接口、还有一个拦截方法的句柄。
 * 在句柄的invoke中如果不调用method.invoke则方法不会执行。在invoke前后添加通知，就是对原有类进行功能扩展了。
 * 创建好代理对象之后，proxy可以调用接口中定义的所有方法，因为它们实现了同一个接口，并且接口的方法实现类的加载器已经被反射框架获取到了。
 */
public class DynProxy {
    public static void main(String []args){
        DaoInterface testDao = new TestDao();
        DaoInterface proxy = (DaoInterface)Proxy.newProxyInstance(
                testDao.getClass().getClassLoader(),
                testDao.getClass().getInterfaces(),
                new InvocationHandler() {
            //回调方法，拦截到对象的时候执行
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("get testDao proxy...");
                Object o = method.invoke(testDao,args);
                return o;
            }
        });

        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
