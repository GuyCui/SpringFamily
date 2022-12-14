package top.sql.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/5 23:27
 * {@code @Description:} smart-framework 属性文件工具类
 */
public class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
    
    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                // file is not found
                throw new FileNotFoundException(fileName + "找不到文件");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            // load properties file failure
            LOGGER.error("加载属性文件失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // close input stream failure
                    LOGGER.error("关闭输入流失败", e);
                }
            }
        }
        
        return props;
    }
    
    /**
     * 获取字符串属性（默认值为空字符串）
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }
    
    /**
     * 获取字符串属性（可指定默认值）
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }
    
    /**
     * 获取数值型属性（默认值0）
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }
    
    /**
     * 获取数值型属性（可指定默认值）
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }
    
    /**
     * 获取布尔值属性（默认值false）
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }
    
    /**
     * 获取布尔值属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}