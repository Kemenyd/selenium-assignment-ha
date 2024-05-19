package com.sa.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue = "com/sa/framework/step_definitions", dryRun = false, tags = "", publish = true, plugin = {
        "pretty", "html:test-output", "html:target/cucumber-html-report"})
public class CukesRunner extends AbstractTestNGCucumberTests {
}
