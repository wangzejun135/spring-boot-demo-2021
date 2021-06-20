package com.example.springbootdemo2021.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES对称加密算法
 * 
 * @see ============================================================================ ===============================
 * @see 这里演示的是其Java6.0的实现,理所当然的BouncyCastle也支持AES对称加密算法
 * @see 另外,我们也可以以AES算法实现为参考,完成RC2,RC4和Blowfish算法的实现
 * @see ============================================================================ ===============================
 * @see 由于DES的不安全性以及DESede算法的低效,于是催生了AES算法(Advanced Encryption Standard)
 * @see 该算法比DES要快,安全性高,密钥建立时间短,灵敏性好,内存需求低,在各个领域应用广泛
 * @see 目前,AES算法通常用于移动通信系统以及一些软件的安全外壳,还有一些无线路由器中也是用AES算法构建加密协议
 * @see ============================================================================ ===============================
 * @see 由于Java6.0支持大部分的算法,但受到出口限制,其密钥长度不能满足需求
 * @see 所以特别需要注意的是:如果使用256位的密钥,则需要无政策限制文件(Unlimited Strength Jurisdiction Policy Files)
 * @see 不过Sun是通过权限文件local_poblicy.jar和US_export_policy.jar做的相应限制 ,我们可以在Sun官网下载替换文件,减少相关限制
 * @see 网址为http://www.oracle.com/technetwork/java/javase/downloads/index.html
 * @see 在该页面的最下方找到Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 6,点击下载
 * @see http://download.oracle.com/otn-pub/java/jce_policy/6/jce_policy-6.zip
 * @see http://download.oracle.com/otn-pub/java/jce/7/UnlimitedJCEPolicyJDK7.zip
 * @see 然后覆盖本地JDK目录和JRE目录下的security目录下的文件即可
 * @see ============================================================================ ===============================
 * @see 关于AES的更多详细介绍,可以参考http://blog.csdn.net/kongqz/article/category/800296
 * @create Jul 17, 2012 6:35:36 PM
 * @author h00138471
 */
public class AESCodec
{
    
    /**
     * 密钥算法
     */
    public static final String KEY_ALGORITHM = "AES";
    
    /**
     * 加解密算法/工作模式/填充方式,Java6.0支持PKCS5Padding填充方式,BouncyCastle支持PKCS7Padding填充方式
     */
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    
    public static final String KEY = "QUFBYWJjZGVmZ2hpamtsbQ==";
    
    /**
     * 转换密钥
     * 
     * @param key 字节key
     * @return Key 密钥
     * @throws Exception 异常
     */
    public static Key toKey(byte[] key)
        throws Exception
    {
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }
    
    /**
     * 加密数据 具体实现： Base64(AES256(明文数据，Base64编码后的密钥))
     * 
     * @param data 待加密数据
     * @param key 密钥， base64编码后的密钥
     * @return 加密后的数据
     * @throws Exception 异常
     * */
    public static String encrypt(String data, String key)
        throws Exception
    {
        Key k = toKey(Base64.decodeBase64(key.getBytes()));
        IvParameterSpec ivSpec = new IvParameterSpec("abcdefghijklmnop".getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, k, ivSpec);
        
        return new String(Base64.encodeBase64(cipher.doFinal(data.getBytes())));
    }
    
    /**
     * 解密数据
     * 
     * @param data 待解密的密文数据
     * @param key base64编码后的密钥
     * @return 解密后的明文数据
     * @throws Exception 异常
     * */
    public static String decrypt(String data, String key)
        throws Exception
    {
        Key k = toKey(Base64.decodeBase64(key.getBytes()));
        IvParameterSpec ivSpec = new IvParameterSpec("abcdefghijklmnop".getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, k, ivSpec);
        return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes())));
    }
    
}
