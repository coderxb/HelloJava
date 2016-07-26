package com.china.gavin.javabase.serializable.demo3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/06/3002453.html
 * 
 * @author xuebing
 */
public class SerializableTransientCtrl implements Serializable {

	private static final long serialVersionUID = 6615432028762480739L;

	private String a;
    
    private String b;
    
    private transient String c;
    
	public SerializableTransientCtrl(String a, String b, String c) {
        this.a = "非瞬时默认实现：" + a;
        this.b = "非瞬时非默认实现："+ b;
        this.c = "瞬时实现：" + c;
    }
    
    private void writeObject(ObjectOutputStream stream) throws IOException{
        stream.defaultWriteObject();
        stream.writeObject(b);
        stream.writeObject(c);
    }
    
    private void readObject(ObjectInputStream stream) throws IOException , ClassNotFoundException{
        stream.defaultReadObject();
        stream.readObject();
        b= "null";
        c = (String)stream.readObject();
    }
    
    public String toString() {
        return a + b + c;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializableTransientCtrl sCtrol = new SerializableTransientCtrl("test1", "test2", "test3");
        System.out.println("序列化之前");
        System.out.println(sCtrol);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos  = new ObjectOutputStream(out);
        oos.writeObject(sCtrol);
        
        System.out.println("反序列化操作之后");
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
		SerializableTransientCtrl src = (SerializableTransientCtrl) ois.readObject();
        System.out.println(src);
    }

}
