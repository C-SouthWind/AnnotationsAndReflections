package com.chj.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.chj.reflection.User");

        //获得类的名字
        System.out.println(c1.getName()); //获得包名 + 类名
        System.out.println(c1.getSimpleName()); //获得类名

        System.out.println("==============================");
        //获得类的属性
        Field[] fields = c1.getFields(); //只能找到public属性

        fields = c1.getDeclaredFields();//找到全部的属性
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("==============================");
        //获得指定属性的值
        //Field name = c1.getField("name");

        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("==============================");
        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
        methods = c1.getDeclaredMethods(); //获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods：" + method);
        }

        //获得指定方法
        //因为重载原因 需要传递参数的类型
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        System.out.println("==============================");
        //获得指定的构造器
        Constructor[] constructors = c1.getConstructors();// 获得public构造方法
        for (Constructor constructor : constructors) {
            System.out.println("正常的：" + constructor);
        }
        constructors = c1.getDeclaredConstructors(); // 获得全部的构造方法
        for (Constructor constructor : constructors) {
            System.out.println("getDeclaredConstructors：" + constructor);
        }

        //获得指定的构造器
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(constructor);
    }
}
