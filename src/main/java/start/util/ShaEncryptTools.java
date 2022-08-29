/*
 * 文 件 名:  ShaEncryptTools.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  SHA加密算法类
 * 修 改 人:  wangzejun
 * 修改时间:  2017-3-24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package start.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 
 * @author wangzejun
 * @version [版本号, 2017-03-27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ShaEncryptTools
{
    
    /**
     * SHA具体加密算法
     */
    public static String Encrypt(String strSrc, String encName)
    {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try
        {
            if (encName == null || encName.equals(""))
            {
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
        return strDes;
    }
    
    /**
     * 字节转码
     */
    public static String bytes2Hex(byte[] bts)
    {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++)
        {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1)
            {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
