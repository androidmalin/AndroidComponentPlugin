package org.chickenhook.restrictionbypass;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ReflectionHelperTest {

    Object reflectiveField;

    @Before
    public void setUp() {
        reflectiveField = new Object();
    }

    @Test
    public void getReflective() throws Exception {
        assertSame(Reflection.getReflective(this, "reflectiveField"), reflectiveField);
    }

    @Test
    public void setReflective() throws Exception {
        Reflection.setReflective(this, "reflectiveField", null);
        assertNull(reflectiveField);
    }
}
