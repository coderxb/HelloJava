/**
 * DESUtilsTest.java   2015年3月4日 下午1:27:18 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.security;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class DESUtilsTest {

    @Test
    public void testetEncryptString() {
        String data = "Hello World";
        String encData = DESUtils.getEncryptString(data);
        System.out.println(data + "加密后的数据 : " + encData);
        assertNotNull(encData);
    }

    @Test
    public void testetDecryptString() {
        String data = "Ue5Ow8qOw6TKeuRm+Y8WCA==";
        String decData = DESUtils.getDecryptString(data);
        System.out.println(data + "解密后的数据 : " + decData);
        assertNotNull(decData);
    }

}
