package com.api.petstore.testservices;

import java.io.IOException;

import com.api.petstore.constants.Endpoints;
import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.utils.JsonFilesPath;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUserDataService extends JsonFilesPath {
	
	ObjectMapper MAPPER = new ObjectMapper();
	CreateUserResponse createResponse = new CreateUserResponse();
	
	public CreateUserResponse updateUserData() throws IOException {

		CreateUserRequest updateUserData = MAPPER.readValue(updateUserFile, CreateUserRequest.class);
		
		JsonNode jsonNode = MAPPER.readTree(createUserFile);
		String userNameNode = jsonNode.get("username").asText();
		
		//System.out.println("UserName is :" +userNameNode);
		
		Response response = RestAssured.given()
				
				
				.contentType(ContentType.JSON)
				.pathParam("username", userNameNode)
				.body(updateUserData)
				.filter(new AllureRestAssured())
				.log().all()
				.put(Endpoints.PUT_DATA);


		String  putData =response.getBody().asString();

		createResponse = MAPPER.readValue(putData, CreateUserResponse.class);

		
		
		return  createResponse;

}

}
