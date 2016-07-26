package com.china.gavin.javabase.serializable.demo2;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用于测试序列化时的deep copy.
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/05/3001149.html.
 * 
 * @author xuebing
 * 
 */
public class House implements Serializable {

	private static final long serialVersionUID = -8239113347097737288L;
	
	private Date date = new Date(); // 记录当前的时间
    
    public String toString() {
        return "House:" + super.toString() + ".Create Time is:" + date;
    }
}
