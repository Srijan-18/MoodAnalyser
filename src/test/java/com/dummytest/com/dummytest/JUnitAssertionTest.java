package com.dummytest.com.dummytest;

import org.junit.Assert;
import org.junit.Test;

public class JUnitAssertionTest {
    @Test
    public void assertionTest() {
        //variables
        String string1="JUnit";
        String string2="JUnit";
        Object obj1=new Object();
        Object obj2=new Object();
        String string5=null;
        int variable1=1;
        int variable2=2;
        int[] array1={1,2,3};
        int[] array2={1,2,3};

        //assert methods
        Assert.assertEquals(string1,string2);
        Assert.assertSame(string1,string2);
        Assert.assertSame(obj1,obj2);
        Assert.assertNotSame(obj1,obj2);
        Assert.assertNotNull(string1);
        Assert.assertNull(string5);
        Assert.assertTrue(variable1<variable2);
        Assert.assertArrayEquals(array1,array2);
    }
}
