package com.sa.framework.step_definitions;


import com.sa.framework.utilities.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        DriverUtil.initDriver();
    }

    @After
    public void teardown() {
        DriverUtil.closeDriver();
    }
}
