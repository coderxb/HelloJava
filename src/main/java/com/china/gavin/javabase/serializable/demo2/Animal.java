package com.china.gavin.javabase.serializable.demo2;

import java.io.Serializable;

/**
 * 
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/05/3001149.html.
 * 
 * @author xuebing
 * 
 */
public class Animal implements Serializable {

	private static final long serialVersionUID = -6451011378844702337L;

	private String name;
    
    private House house;
    
    public Animal(String name , House house) {
        this.name = name;
        this.house = house;
        System.out.println("调用了构造器");
    }
    
    public String toString() {
        return  name + "[" +super.toString() + "']" + house;
    }

}
