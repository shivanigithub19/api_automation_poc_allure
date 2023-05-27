package com.api.petstore.testcases;

import java.io.IOException;
import java.sql.SQLException;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.testservices.CreateUserDataService;
import com.api.petstore.testservices.GetUserDataService;
import com.api.petstore.utils.TestBase;
import com.fasterxml.jackson.databind.JsonNode;





public class GetDataTest extends TestBase {
	
	GetUserDataService getData = new GetUserDataService();
	
	CreateUserRequest createRequest = new CreateUserRequest();


@Test
	
	public void testGetUserData() throws IOException, SQLException {

	logger.info("********* Started TC001_retrieve single user **********");
		
		SoftAssertions softAssert = new SoftAssertions();
		createRequest = getData.getUserData();
		
		
		
		
		softAssert.assertThat(createRequest.getUsername()).isEqualTo("randomUser");
		
		softAssert.assertAll();
		
		
		

				
	}



}
