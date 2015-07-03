package my.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by paul on 2015/6/30.
 */
public class Sha {
    public static void process(String text) throws NoSuchAlgorithmException {
        System.out.println("原始数据：" + text);
        BigInteger bigInteger = null;

        MessageDigest md = MessageDigest.getInstance("SHA");
        byte[] inputData = text.getBytes();
        bigInteger = new BigInteger(md.digest());
        md.update(inputData);
        bigInteger = new BigInteger(md.digest());
        System.out.println("加密后数据：" + bigInteger.toString(16));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        process("数据123");
    }
}
