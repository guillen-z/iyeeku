package com.iyeeku.watch.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class SecurityUtil {

    public static String DES = "AES"; // optional value AES/DES/DESede

    public static String CIPHER_ALGORITHM = "AES"; // optional value AES/DES/DESede

    public static Key getKey(String strKey) {
        try {
            if (strKey == null) {
                strKey = "";
            }
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            KeyGenerator _generator = KeyGenerator.getInstance("AES");
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128, secureRandom);
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(" 初始化密钥出现异常 ");
        }
    }

    public static String encrypt(String data, String key) throws Exception {
        Key secureKey = getKey(key);
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
        byte[] bt = cipher.doFinal(data.getBytes());
        String strS = new BASE64Encoder().encode(bt);
        return strS;
    }

    public static String decrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom sr = new SecureRandom();
        Key secureKey = getKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
        byte[] res = new BASE64Decoder().decodeBuffer(message);
        res = cipher.doFinal(res);
        return new String(res);
    }
    
}
