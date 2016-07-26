package com.china.gavin.javabase.enumeration;

/**
 * 
 * 这是在JDK1.5之前使用定义Eunm.
 * 
 */
public class Season {

    private final String name;
    private final String desc;

    //声明为final的属性，在构造器中初始化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    //Create enum object
    public static final Season SPRING = new Season("Spring", "Spring");
    public static final Season SUMMER = new Season("Summer", "Summer");
    public static final Season AUTUMN = new Season("Autumn", "Autumn");
    public static final Season WINTER = new Season("Winter", "Winter");

    //通过公共的方法来调用属性
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season [name=" + name + ", desc=" + desc + "]";
    }

}
