package basic.knowledge;


import org.hashids.Hashids;

/**
 * @Author: CarryJey @Date: 2018/10/12 15:58:31
 * hashids 加解密测试
 * client和server端传输数据可采用这种简答方式进行数据加密处理
 */

public class HashIdsTest {

    /**
     * hash加密
     *
     * @return
     */
    public static String test() {
        /**
         * 这里注意要与解密方使用相同的salt值，若不同则无法对应
         */
        Hashids hashids = new Hashids("test");
        String id1 = hashids.encode(12345L);
        System.out.println("id1 :" + id1);
        return id1;
    }

    /**
     * hash解密
     *
     * @param id1
     */
    public static void test02(String id1) {
        Hashids hashids = new Hashids("test");
        long[] ids = hashids.decode(id1);
        if (ids.length != 0) {
            System.out.println("id2 :" + ids[0]);
        }else {
            System.out.println("id2 is null");
        }
    }

    public static void main(String args[]) {
        String id1 = test();
        test02(id1);
    }
}
