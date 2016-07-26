package com.china.gavin.javabase;

import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import com.china.gavin.javabase.enumeration.Light;

public class LightTest {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	/**
	 * 演示枚举类型的遍历
	 */
	public void testTraversalEnum() {
		Light[] allLight = Light.values();
		for (Light aLight : allLight) {
			System.out.println(" 当前灯 name ： " + aLight.name());
			System.out.println(" 当前灯 ordinal ： " + aLight.ordinal());
			System.out.println(" 当前灯： " + aLight);
		}
	}

    @Test
    public void testUUID() {
        UUID uuid = UUID.randomUUID();
        // System.out.print("Long : timesstamp = " + uuid.timestamp());
        System.out.println("Int : variant = " + uuid.variant());
        System.out.println("String : toString = " + uuid.toString());
    }

}
