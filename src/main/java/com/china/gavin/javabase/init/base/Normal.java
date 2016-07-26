package com.china.gavin.javabase.init.base;

/**
 * 普通类初始化
 * @ClassName: Normal
 * @Description: TODO(普通类的初始化，先是初始化块，然后是构造方法 )
 * 结论：对象初始化时，先是初始化块，然后才是构造方法。 
 * @author 李雪冰  Snowice Lee
 * @date 2011-8-6 上午10:15:54
 *
 */
public class Normal {
	
    {   
        System.out.println("Normal <init></init>");   
    }   
    
    public Normal (){   
        System.out.println("Normal construct");   
    } 
    
	public static void main(String[] args) {
		Normal n = new Normal();
	}

}
