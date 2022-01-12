package com.chj.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class test09 {
    public static void main(String[] args) throws Exception {
        //获得Class对象
        Class<?> c1 = Class.forName("com.chj.reflection.User");

        //构造一个对象
        User user = (User) c1.newInstance();//本质是调用了类的无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User chj = (User) declaredConstructor.newInstance("chj", 007, 18);
        System.out.println(chj);

        //通过反射调用普通方法
        User user2 = (User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke : 激活的意思
        //（对象，"方法的值"）
        setName.invoke(user2,"chj");
        System.out.println(user2);


        //通过反射操作属性
        System.out.println("==================================");
        User user3 = (User)c1.newInstance();

        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user3,"chj");
        System.out.println(user3);
    }
}
