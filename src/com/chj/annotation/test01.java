package com.chj.annotation;

//什么是注解
public class test01 extends Object{

    //重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //不推荐程序员使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

}
