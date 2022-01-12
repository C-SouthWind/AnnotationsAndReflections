package com.chj.reflection;

import java.lang.reflect.Method;

//测试反射性能
public class test10 {
    public static void main(String[] args) throws NoSuchMethodException {
        test1();
        test2();
        test3();
    }

    //普通方法
    public static void test1(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用：" + (endTime - startTime) + "ms");
    }
    //反射方法
    public static void test2() throws NoSuchMethodException {
        Class<User> c1 = User.class;
        Method getName = c1.getDeclaredMethod("getName");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法调用：" + (endTime - startTime) + "ms");
    }
    //反射关闭检测方法
    public static void test3() throws NoSuchMethodException {
        Class<User> c1 = User.class;
        Method getName = c1.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射关闭检测方法调用：" + (endTime - startTime) + "ms");
    }
}
