package basic.knowledge.设计模式;

/**
 * @Author: CarryJey @Date: 2018/10/17 13:48:18
 * dsc:单例模式
 */

/**单例模式的关键点
 *1) 构造方法不对外开放,为private
 *2) 确保单例类只有一个对象,尤其是多线程模式下
 *3) 通过静态方法或枚举返回单例对象
 *4) 确保单例类在反序列化是不会重新创建新的对象
 **/
public class Singleton {

    /**
     * 1、饿汉式：在声明的时候即初始化类。
     */
    //    private static Singleton instance = new Singleton();
    //
    //    public Singleton getInstance() {
    //        return instance;
    //    }

    /**
     * 2、懒汉式
     * getInstance 添加了synchronized 关键字,,也就是说 getInstance 是一个同步方法, 这就是懒汉式在多线程中保持唯一性的方式
     * 懒汉式存在的问题是,即是instance已经被创建,每次调用getInstance方法还是会同步,这样就会浪费一些不必要的资源
     */
    //     private static Singleton singleton;
    //     public static synchronized Singleton getInstance(){
    //         if(singleton == null){
    //             singleton = new Singleton();
    //         }
    //         return singleton;
    //     }

    /**
     * 3、Double Check Lock(DCL模式)
     * getInstance 进行了两次判空,第一次判空是为了不必要的同步,第二次判空为了在instance 为 null 的情况下创建实例
     * 优点:资源利用率高,效率高
     * 缺点:第一次加载稍慢,由于java处理器允许乱序执行,偶尔会失败     
     */
//    private static Singleton singleton;
//    public static Singleton getInstance(){
//        if(singleton == null){
//            synchronized (Singleton.class){
//                if(singleton == null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    /**
     * 4、静态内部类实现单例模式（推荐使用这种方式）
     *当第一次加载Singleton类时并不会初始化,只有第一次调用getInstance方法的时候才会初始化调用并进行初始化
     *第一次调用getInstance 方法的时候虚拟机才会加载SingletonHoder类,这种方式不仅能够保证线程安全,也能够保证对象的唯一,还延迟了单例的实例化,所有推荐使用这种方式
     */
    public static class SingleTonCreater{
        private static final Singleton singleton = new Singleton();
    }
    public Singleton getInstance(){
        //只能第一次调用时加载一次，考虑了灵活性和单例性
        return SingleTonCreater.singleton;
    }
}
