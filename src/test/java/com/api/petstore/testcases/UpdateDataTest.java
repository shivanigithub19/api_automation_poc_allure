package com.api.petstore.testcases;

import java.io.IOException;
import java.sql.SQLException;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.testservices.CreateUserDataService;
import com.api.petstore.testservices.GetUserDataService;
import com.api.petstore.testservices.UpdateUserDataService;
import com.api.petstore.utils.TestBase;
import com.fasterxml.jackson.databind.JsonNode;





public class UpdateDataTest extends TestBase {
	
	UpdateUserDataService updateData = new UpdateUserDataService();
	
	CreateUserResponse createResponse = new CreateUserResponse();


@Test
	
	public void testUpdateUserData() throws IOException, SQLException {

	logger.info("********* Started TC001_update user details **********");
		
		SoftAssertions softAssert = new SoftAssertions();
		createResponse = updateData.updateUserData();
		
		
		
		
		softAssert.assertThat(createResponse.getCode()).isEqualTo(200);
		softAssert.assertThat(createResponse.getMessage()).isEqualTo("1001");
		softAssert.assertThat(createResponse.getType()).isNotEmpty();
		softAssert.assertAll();
		
		
		

				
	}



}
