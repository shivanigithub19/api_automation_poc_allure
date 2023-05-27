package com.api.petstore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class TestBase   {

	public Logger logger;

	@BeforeClass
	public void setup() throws IOException {

		
		logger = LoggerFactory.getLogger("API Automation - Rest Assured");
		
		
		
		
				 
		Properties pro;
		File src = new File("config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		RestAssured.baseURI = pro.getProperty("baseUrl");
		return;
		
		
		

	}
	
	

	}
