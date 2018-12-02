package basic.knowledge.basic;

import java.util.function.Function;

/**
 * @author CarryJey
 * @since 2018/11/8
 * java的Function方法的简单使用
 * https://blog.csdn.net/qq_37465368/article/details/83862469
 */
public class JavaFuntionExample {

    public static void testFunction(int basic, Function<Integer, Integer> function) {
        int value = function.apply(basic);
        System.out.print(value + "\n");
    }

    public static void main(String... args) {
        testFunction(1, val -> val + 1000);
        testFunction(5, val -> val * 100);
    }
}
