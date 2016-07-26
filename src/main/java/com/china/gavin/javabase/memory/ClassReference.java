package com.china.gavin.javabase.memory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ClassReference {

	/**
	 * Java对对象的4种引用:强引用(new Object()), 软引用(SoftReference类), 弱引用(WeakReference类),
	 * 虚引用(PhantomReference类)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// instance Object
		Person person = new Person("Sunny");
		// create a reference queue
		ReferenceQueue<Person> rq = new ReferenceQueue<Person>();
		// create a PhantomReference, Let PhantomReference to Person Object
		PhantomReference<Person> pr = new PhantomReference<Person>(person, rq);
		// Cutting off person reference variable and object reference
		person = null;
		// Trying to remove virtual reference refers to the object
		// Discovery process and can not pass virtual reference access reference
		// object，So output is null
		System.out.println(pr.get());
		// Mandatory garbage collection/recover
		System.gc();
		System.runFinalization();
		// Once the PhantomReference object is recovered,
		// the virtual reference enters the ReferenceQueue;
		// So first to enter the queue referenced in the queue to be compared
		// with the pr , Output true
		System.out.println(rq.poll() == pr);
	}
}
