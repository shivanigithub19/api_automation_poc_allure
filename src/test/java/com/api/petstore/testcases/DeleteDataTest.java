package com.api.petstore.testcases;

import java.io.IOException;
import java.sql.SQLException;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.testservices.CreateUserDataService;
import com.api.petstore.testservices.DeleteUserDataService;
import com.api.petstore.utils.TestBase;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;





public class DeleteDataTest extends TestBase {
	
	DeleteUserDataService deleteData = new DeleteUserDataService();
	CreateUserResponse createResponse = new CreateUserResponse();
	ObjectMapper MAPPER = new ObjectMapper();


@Test
	
	public void testDeleteUser() throws IOException, SQLException {

	logger.info("********* Started TC001_delete single user **********");
		
		SoftAssertions softAssert = new SoftAssertions();
		createResponse = deleteData.deleteUserData();
		
		
		
		softAssert.assertThat(createResponse.getCode()).isEqualTo(200);
		softAssert.assertThat(createResponse.getMessage()).isEqualTo("randomUser");
		softAssert.assertThat(createResponse.getType()).isNotEmpty();
		softAssert.assertAll();
		
		
		

				
	}



}
