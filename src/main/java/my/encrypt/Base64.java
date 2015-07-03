package my.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by paul on 2015/6/30.
 */
public class Base64 {
    public static byte[] decrypt(String key) throws IOException {
        return new BASE64Decoder().decodeBuffer(key);
    }

    public static String encrypt(byte[] key) {
        return new BASE64Encoder().encodeBuffer(key);
    }

    public static void main(String[] args) throws IOException {
        String str = "1234";
        String result1 = Base64.encrypt(str.getBytes());
        System.out.println("加密后密文为：" + result1);

        byte[] result2 = Base64.decrypt(result1);
        System.out.println("解密后：" + new String(result2));
    }
}
