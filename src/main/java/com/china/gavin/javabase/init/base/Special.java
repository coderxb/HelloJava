package com.china.gavin.javabase.init.base;

/**
 * 继承于普通类的初始化
 * @ClassName: Special
 * @Description: TODO(继承于普通类，首先是父类初始化块，然后是父类构造方法，之后是子类的初始化块，最后是子类构造方法)
 *  结论：先初始化父类（默认调用父类的无参构造方法），然后才初始化子类。
 * @author 李雪冰  Snowice Lee
 * @date 2011-8-6 上午10:21:06
 */
public class Special extends Normal {
    {   
        System.out.println("Special <init></init>");   
    }   
  
    public Special()    
    
    {   
        System.out.println("Special construct");   
    }
	public static void main(String[] args) {
		Special s = new Special();

	}

}
