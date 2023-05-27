package com.api.petstore.testcases;

import java.io.IOException;
import java.sql.SQLException;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.testservices.CreateUserDataService;
import com.api.petstore.utils.TestBase;





public class CreateDataTest extends TestBase {
	
	CreateUserDataService createData = new CreateUserDataService();
	CreateUserResponse createResponse = new CreateUserResponse();
	CreateUserRequest createRequest = new CreateUserRequest();


@Test
	
	public void testCreateUser() throws IOException, SQLException {

	logger.info("********* Started TC001_create single user **********");
		
		SoftAssertions softAssert = new SoftAssertions();
		createResponse = createData.createUser();
		
		
		
		softAssert.assertThat(createResponse.getCode()).isEqualTo(200);
		softAssert.assertThat(createResponse.getMessage()).isEqualTo("1001");
		softAssert.assertThat(createResponse.getType()).isNotEmpty();
		softAssert.assertAll();
		
		
		

				
	}



}
