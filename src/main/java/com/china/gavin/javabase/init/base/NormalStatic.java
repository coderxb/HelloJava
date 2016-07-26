package com.china.gavin.javabase.init.base;

/**
 * 普通类静态初始化
 * @ClassName: NormalStatic
 * @Description: TODO(有静态初始化的类，首先是初始化静态块，然后是一般的初始化块，最后是构造方法 )
 * 结论：先是初始化静态部分，然后才初始化其他部分（类是先加载，然后才创建对象，而静态部分是在类加载时初始化的）。
 * @author 李雪冰  Snowice Lee
 * @date 2011-8-6 上午10:18:08
 *
 */
public class NormalStatic {
    static  
    {   
        System.out.println("NormalStatic ");   
    }   
       
    {   
        System.out.println("NormalStatic <init></init>");   
    }   
       
    public NormalStatic ()   
    {   
        System.out.println("NormalStatic construct");   
    }
    
	public static void main(String[] args) {
		NormalStatic n = new NormalStatic();
		//静态块，只初始化一次
		n = new NormalStatic();
	}

}
