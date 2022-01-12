package com.chj.reflection;

//类加载器
public class test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载的父类加载器 ---》 扩展类记载器
        ClassLoader parent = systemClassLoader.getParent();

        //获取扩展类加载器的父类加载器 ---》 根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是那个加载器加载的
        ClassLoader classLoader = Class.forName("com.chj.reflection.test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));


        //双亲委派机制   一层一层找 如果系统有就不会加载自己的包  例如 自己创建java.lang.String文件 永远不会使用自己的，因为系统已经进行定义
    }
}
