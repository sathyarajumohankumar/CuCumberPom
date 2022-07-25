package com.testleaftestcases;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/com/testleaf/features/MergeLeads.feature", glue = "com/testleaf/pages", monochrome = true)
public class Runnr extends ProjectSpecificMethods {

}