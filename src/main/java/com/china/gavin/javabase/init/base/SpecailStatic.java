package com.china.gavin.javabase.init.base;

/**
 * 继承于有静态初始化的类的初始化
 * @ClassName: SpecailStatic
 * @Description: TODO(继承于有静态初始化的类，首先是父类静态初始化，然后是子类静态初始化，之后是父类初始化，最后子类初始化)
 * 结论：先静后动，先父后子。
 * @author 李雪冰  Snowice Lee
 * @date 2011-8-6 上午10:23:29
 *
 */
public class SpecailStatic extends NormalStatic{
    static   
    {   
        System.out.println("SpecialStatic ");   
    }   
       
    {   
        System.out.println("SpecialStatic <init></init>");   
    }   
       
    public SpecailStatic ()    
    {   
        System.out.println("SpecialStatic construct");   
    }
	public static void main(String[] args) {
		SpecailStatic s = new SpecailStatic();
	}

}
