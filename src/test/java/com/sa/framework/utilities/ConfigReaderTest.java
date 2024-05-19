package com.sa.framework.utilities;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConfigReaderTest {

    @Test
    public void configValueTest() { // test to be sure Config reader is working properly
        String keyValue = ConfigReader.getProperty("browserType");
        assertEquals(keyValue, "chrome");
    }
}
