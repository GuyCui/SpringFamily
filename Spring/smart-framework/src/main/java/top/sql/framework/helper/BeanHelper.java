package top.sql.framework.helper;

import top.sql.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/7 21:12
 * {@code @Description:} smart-framework Bean助手类
 */
public final class BeanHelper {
    /**
     * 定义Bean映射（用于存放Bean类与Bean实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();
    
    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }
    
    /**
     * 获取Bean映射
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }
    
    /**
     * 获取Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            // can not get bean by class
            throw new RuntimeException("无法获取该类的bean" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }
    
}
