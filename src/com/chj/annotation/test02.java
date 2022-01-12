package com.chj.annotation;

import java.lang.annotation.*;

//测试元注解
@MyAnnotation
public class test02 {

}


//定义一个注解
//Target 表示我们的注解可以用在那些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention 表示我们的注解声明地方还有校
//runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)
//Documented 表示是否将我们的注解生产在Javadoc中
@Documented
//Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
