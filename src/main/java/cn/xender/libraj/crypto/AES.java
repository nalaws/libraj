package cn.xender.libraj.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static byte[] encryptAES(byte[] key, byte[] data, byte[] iv) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] cipherText = cipher.doFinal(data);
        return  cipherText;
    }

    public static byte[] decryptAES(byte[] key, byte[] cipherText, byte[] iv) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] plainText = cipher.doFinal(cipherText);
        return  plainText;
    }

}
