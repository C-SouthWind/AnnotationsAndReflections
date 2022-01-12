package com.chj.reflection;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

//练习反射操作注解
public class test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.chj.reflection.Student2");
        //通过反射获得注解
        Annotation[] declaredAnnotations = c1.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
        //获得注解的值
        TableChj tableChj = c1.getDeclaredAnnotation(TableChj.class);
        System.out.println(tableChj.value());

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldChj annotation = name.getAnnotation(FieldChj.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

        System.out.println("===================");

        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            Field declaredField = c1.getDeclaredField(field.getName());
            FieldChj annotation1 = declaredField.getAnnotation(FieldChj.class);
            System.out.println(annotation1.columnName());
            System.out.println(annotation1.type());
            System.out.println(annotation1.length());
        }
    }
}

@TableChj("db_student")
class Student2{
    @FieldChj(columnName = "db_id",type = "int",length = 2)
    private int id;
    @FieldChj(columnName = "db_age",type = "int",length = 2)
    private int age;
    @FieldChj(columnName = "db_name",type = "varchar",length = 2)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student2() {
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableChj{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldChj{
    String columnName();
    String type();
    int length();

}