package com.thyonix;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class BeanFactory {
    private static Properties properties = new Properties();

    // 加载配置文件
    static {
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T getBean(String beanName,Class<T> clazz) {
        T bean = null;
        try {
            // 获取类的全限定名
            String className = properties.getProperty(beanName);
            if (className == null) {
                throw new IllegalArgumentException("No bean found with name: " + beanName);
            }

            // 创建 Class 对象
            Class<?> beanClass = Class.forName(className);
            if (!clazz.isAssignableFrom(beanClass)) {
                throw new ClassCastException("Class " + className + " is not a subtype of " + clazz.getName());
            }

            // 创建 Bean 实例
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object instance = constructor.newInstance();

            // 类型转换
            bean = clazz.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
