package com.example.springbootdemo2021.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密工具
 * 
 * @author zWX280444
 * @version C102 2015-5-27
 * @since SDP V300R003C102
 */
public class AESCipher
{
    // 定义 加密算法
    private static final String Algorithm = "AES";
    
    /**
     * 获取128位密钥
     * 
     * @author zWX280444
     * @param key 用于生成密钥的字符串
     * @return 密钥
     * @throws UnsupportedEncodingException
     */
    private static byte[] getSecretKey(String key)
        throws UnsupportedEncodingException
    {
        byte[] skey = key.substring(0, 16).getBytes("UTF-8");
        return skey;
        
    }
    
    /**
     * 转换密钥
     * 
     * @param key 字节key
     * @return Key 密钥
     * @throws Exception 异常
     */
    private static Key toKey(byte[] key)
        throws Exception
    {
        return new SecretKeySpec(key, Algorithm);
    }
    
    /**
     * AES/ECB/PKCS5Padding解密
     * 
     * @author zWX280444
     * @param data 需解密的字节数组
     * @param key 密钥
     * @return 解密后的字节数组
     * @throws Exception
     */
    public static byte[] decryptECB(byte[] data, byte[] key)
        throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, toKey(key));
        byte[] result = cipher.doFinal(data);
        return result;
    }
    
    /**
     * AES/ECB/PKCS5Padding解密
     * 
     * @author zWX280444
     * @param data 需解密的密文字符串
     * @param key 用于生成密钥的字符串
     * @return 解密后的明文
     * @throws Exception
     */
    public static String decryptECB(String data, String key)
        throws Exception
    {
        if (StrUtil.isEmpty(key) || key.length() < 16)
        {
            return null;
        }
        
        // 将字符串转化为字节数组
        byte[] decryptdata = Base64.decode(data);
        byte[] skey = getSecretKey(key);
        
        // 解密
        byte[] decryptContent = decryptECB(decryptdata, skey);
        
        // 转化为字符串
        return new String(decryptContent);
    }
    
    /**
     * AES/ECB/PKCS5Padding加密
     * 
     * @author zWX280444
     * @param content 需加密的明文字节数组
     * @param key 密钥
     * @return 密文字节数组
     * @throws Exception
     */
    public static byte[] encryptECB(byte[] content, byte[] key)
        throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, toKey(key));
        byte[] result = cipher.doFinal(content);
        return result;
    }
    
    /**
     * AES/ECB/PKCS5Padding加密
     * 
     * @author zWX280444
     * @param content 需加密的明文
     * @param key 用于生成密钥的字符串
     * @return 密文字符串
     * @throws Exception
     */
    public static String encryptECB(String content, String key)
        throws Exception
    {
        // 将字符串转化为字节数组
        byte[] encryptcontent = content.getBytes();
        byte[] skey = getSecretKey(key);
        
        // 加密
        byte[] encryptData = encryptECB(encryptcontent, skey);
        
        // Base64转化为字符串
        return Base64.encode(encryptData);
    }
    
//    public static void main(String[] args)
//        throws Exception
//    {
//        String content = "zhangsan='1245'";
//        String key = "version5.0";
//        String en = encryptECB(content, key);
//        System.out.println("加密后：" + en);
//        String jie = decryptECB(en, key);
//        System.out.println("解密后：" + jie);
//    }
}
