/*
 * 文  件  名：PortalConfigTools.java
 * 版        权：Copyright 2012-2014 Huawei Tech.Co.Ltd. All Rights Reserved.
 * 描        述：portal.properties ,可以添加一些需要动态加载的数据
 * 修  改  人：mWX177641
 * 修改时间：2013-8-27
 * 修改内容：新增
 */
package com.example.springbootdemo2021.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.huawei.bme.commons.om.log.DebugLog;
import com.huawei.bme.commons.om.log.LogFactory;
import com.huawei.iread.portal.common.SystemConfig;
import com.huawei.iread.util.Util;

/**
 * portal.properties ,可以添加一些需要动态加载的数据
 * 
 * @author hKF29277
 * @version CMR20 2013-8-27
 * @since V100R001C01LCM020
 */
public class PortalConfigTools
{
    
    /**
     * 日志对象
     */
    private final static DebugLog logger = LogFactory.getDebugLog(PortalConfigTools.class);
    
    /**
     * 配置文件路径
     */
    private static final String PATH = SystemConfig.getInstance().getConfigPath() + "portal.properties";
    
    private static final File file = new File(PATH);
    
    /**
     * 更新时间
     */
    private long lastUpdate = file.lastModified();
    
    /**
     * 配置信息
     */
    private Properties properties;
    
    /**
     * 单实例对象
     */
    private static final PortalConfigTools instanse = new PortalConfigTools();
    
    /**
     * 单实例方法
     * 
     * @author mWX177641
     * @return 单实例
     */
    public static PortalConfigTools getInstanse()
    {
        return instanse;
    }
    
    /**
     * 构造函数
     */
    private PortalConfigTools()
    {
        load();
    }
    
    /**
     * 
     * 当初始化是加载数据
     * 
     * @author mWX177641
     */
    public void load()
    {
        Properties pro = new Properties();
        FileInputStream input = null;
        try
        {
            input = new FileInputStream(file);
            pro.load(input);
            
            // 更新properties；
            setPrpoperties(pro);
        }
        catch (IOException e)
        {
            logger.error("load portal.properties is error", e);
        }
        finally
        {
            closeIo(input);
        }
    }
    
    /**
     * 关闭IO流
     * 
     * @author mWX177641
     * @param input 输入流
     */
    private void closeIo(FileInputStream input)
    {
        if (input != null)
        {
            try
            {
                input.close();
            }
            catch (IOException e)
            {
                logger.error("close io", e);
            }
        }
    }
    
    /**
     * 是否有更新过
     * 
     * @author mWX177641
     * @return true 更新过
     */
    private boolean isUpdate()
    {
        long lastModified = file.lastModified();
        boolean isUpdate = (this.lastUpdate != lastModified);
        if (isUpdate)
        {
            this.lastUpdate = lastModified;
        }
        return isUpdate;
    }
    
    /**
     * 获取key对应的数据
     * 
     * @author mWX177641
     * @param key 关键字
     * @return 对应的值
     */
    public String getValue(String key)
    {
        try
        {
            if (logger.isDebugEnable())
            {
                logger.debug("key is " + key);
            }
            if (isUpdate())
            {
                load();
            }
            return getProperties().getProperty(key);
        }
        catch (Exception e)
        {
            String[][] appinfo = new String[][]{{"key", key}};
            logger.error("PortalConfigTools.getValue() error!", appinfo, e);
            return null;
        }
    }
    
    /**
     * 
     * 获取参数值 为空设置默认值
     *
     * @author wangzhuohui
     * @param key
     * @param defaultValue
     * @return
     */
    public String getValue(String key, String defaultValue)
    {
        String value = null;
        try
        {
            if (logger.isDebugEnable())
            {
                logger.debug("key is " + key);
            }
            if (isUpdate() || Util.isEmpty(getProperties()))
            {
                load();
            }
            value = getProperties().getProperty(key, defaultValue);
        }
        catch (Exception e)
        {
            String[][] appinfo = new String[][]{{"key", key}, {"defaultValue", defaultValue}};
            logger.error("PortalConfigTools.getValue() error!", appinfo, e);
            value = defaultValue;
        }
        
        return value;
    }
    
    /**
     * 当文件有更新时，需要替换调旧的Properties,这时候要注意线程方面的安全问题
     * 
     * @author mWX177641
     * @return 当前配置文件信息
     */
    public Properties getProperties()
    {
        synchronized (this)
        {
            return properties;
        }
    }
    
    /**
     * 当文件有更新时，需要替换调旧的Properties,这时候要注意线程方面的安全问题
     * 
     * @author mWX177641
     * @param pro 配置文件信息
     */
    public void setPrpoperties(Properties properties)
    {
        synchronized (this)
        {
            this.properties = properties;
        }
    }
}
