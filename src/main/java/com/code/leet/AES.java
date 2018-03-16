package com.code.leet;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

public class AES {
    public static String KEY = "2c8c69d98acf43759fe1335f0b566a39";
    private Cipher cipher_encrypt;
    private Cipher cipher_decrypt;

    private AES(String key) {
        this.initEncryptCipher(key);
        this.initDecryptCipher(key);
    }

    public static AES getInstance() {
        return new AES(KEY);
    }

    private void initEncryptCipher(String key) {
        try {
            this.cipher_encrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec("aaaaaaaaaaaaaaaa".getBytes("utf-8"), "AES");
            this.cipher_encrypt.init(1, secretKey);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private void initDecryptCipher(String key) {
        try {
            this.cipher_decrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            SecretKey secretKey = new SecretKeySpec(hexStringToByteArray(key), "AES");
            SecretKey secretKey = new SecretKeySpec("aaaaaaaaaaaaaaaa".getBytes("utf-8"), "AES");
            this.cipher_decrypt.init(2, secretKey);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public byte[] encrypt(byte[] bytes) {
        try {
            byte[] result = this.cipher_encrypt.doFinal(bytes);
            return result;
        } catch (IllegalBlockSizeException var3) {
            var3.printStackTrace();
        } catch (BadPaddingException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public byte[] decrypt(byte[] bytes) {
        try {
            byte[] result = this.cipher_decrypt.doFinal(bytes);
            return result;
        } catch (IllegalBlockSizeException var3) {
            var3.printStackTrace();
        } catch (BadPaddingException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        AES instance = AES.getInstance();
        instance.initDecryptCipher(KEY);
        String content = "zzq";
        AtomicInteger atomicInteger;

        try {
            byte[] encrypt = instance.encrypt(content.getBytes("utf-8"));
            String s = Base64.getUrlEncoder().encodeToString(encrypt);
            System.out.println(s);
            String s1 = Base64.getEncoder().encodeToString("zzq".getBytes("utf-8"));
            System.out.println(s1);

        } catch (Exception e) {

        }
    }
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len/2];

        for(int i = 0; i < len; i+=2){
            data[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }

        return data;
    }
}
