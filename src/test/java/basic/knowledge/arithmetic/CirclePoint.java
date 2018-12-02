package basic.knowledge.arithmetic;

/**
 * @author CarryJey
 * @since 2018/11/9
 */
public class CirclePoint {

    public static String convertMD5(String str) {
        char a[] = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        String res = "http://tinyurl.com/";
        res += convertMD5(longUrl);
        System.out.print(res);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        String str[] = shortUrl.split("/");
        return convertMD5(str[3]);
    }

    public static void main(String... args) {
        String str = "https://leetcode.com/problems/design-tinyurl";
        System.out.print(convertMD5(str));
//        System.out.print("加密：" + encode(str) + "\n");
//        System.out.print("解密：" + decode(encode(str)) + "\n");
    }
}
